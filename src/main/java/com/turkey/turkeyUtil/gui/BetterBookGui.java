package com.turkey.turkeyUtil.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.theprogrammingturkey.gobblecore.network.NetworkManager;
import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.network.UtilPacket;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class BetterBookGui extends GuiScreen
{
	private static final ResourceLocation bookGuiTextures = new ResourceLocation("textures/gui/book.png");
	/** The player editing the book */
	private final EntityPlayer editingPlayer;
	private final ItemStack bookObj;
	/** Whether the book is signed or can still be edited */
	private boolean bookisAuthored;
	/** Update ticks since the gui was opened */
	private int updateCount;
	private int bookImageWidth = 192;
	private int bookImageHeight = 192;
	private int bookTotalPages = 1;
	private int currPage;
	private NBTTagList bookPages;
	private String bookTitle = "";
	private BetterBookGui.NextPageButton buttonNextPage;
	private BetterBookGui.NextPageButton buttonPreviousPage;
	private GuiButton buttonDone;
	/** The GuiButton to sign this book. */
	private GuiButton buttonCancel;

	public BetterBookGui(EntityPlayer player, ItemStack stack)
	{
		this.editingPlayer = player;
		this.bookObj = stack;

		if(stack.hasTagCompound())
		{
			bookisAuthored = !stack.getTagCompound().getString("author").equalsIgnoreCase("");
			NBTTagCompound nbttagcompound = stack.getTagCompound();
			this.bookPages = nbttagcompound.getTagList("pages", 8);

			if(this.bookPages != null)
			{
				this.bookPages = (NBTTagList) this.bookPages.copy();
				this.bookTotalPages = this.bookPages.tagCount();

				if(this.bookTotalPages < 1)
				{
					this.bookTotalPages = 1;
				}
			}
		}
		else
		{
			bookisAuthored = false;
			stack.setTagInfo("author", new NBTTagString(""));
			stack.setTagInfo("authorName", new NBTTagString(""));
			stack.setTagInfo("title", new NBTTagString(""));
		}

		if(this.bookPages == null)
		{
			this.bookPages = new NBTTagList();
			this.bookPages.appendTag(new NBTTagString(""));
			this.bookTotalPages = 1;
		}
	}

	/**
	 * Called from the main game loop to update the screen.
	 */
	public void updateScreen()
	{
		super.updateScreen();
		++this.updateCount;
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	public void initGui()
	{
		this.buttonList.clear();
		Keyboard.enableRepeatEvents(true);

		if(!this.bookisAuthored)
		{
			this.buttonList.add(this.buttonCancel = new GuiButton(3, this.width / 2 - 100, 4 + this.bookImageHeight, 98, 20, I18n.format("gui.cancel", new Object[0])));
			this.buttonList.add(this.buttonDone = new GuiButton(0, this.width / 2 + 2, 4 + this.bookImageHeight, 98, 20, I18n.format("gui.done", new Object[0])));
		}
		else
		{
			this.buttonList.add(this.buttonDone = new GuiButton(0, this.width / 2 - 100, 4 + this.bookImageHeight, 200, 20, I18n.format("gui.done", new Object[0])));
		}

		int i = (this.width - this.bookImageWidth) / 2;
		byte b0 = 2;
		this.buttonList.add(this.buttonNextPage = new BetterBookGui.NextPageButton(1, i + 120, b0 + 154, true));
		this.buttonList.add(this.buttonPreviousPage = new BetterBookGui.NextPageButton(2, i + 38, b0 + 154, false));
		this.updateButtons();
	}

	/**
	 * Called when the screen is unloaded. Used to disable keyboard repeat events
	 */
	public void onGuiClosed()
	{
		Keyboard.enableRepeatEvents(false);
	}

	private void updateButtons()
	{
		this.buttonNextPage.visible = this.currPage < this.bookTotalPages - 1 || this.getBookAuthor().equalsIgnoreCase(editingPlayer.getUniqueID().toString());
		this.buttonPreviousPage.visible = this.currPage > 0;
		this.buttonDone.visible = true;
		if(!this.bookisAuthored)
			this.buttonCancel.visible = !this.bookisAuthored;
	}

	private void sendBookToServer()
	{
		if(this.bookPages != null)
		{
			String s;

			while(this.bookPages.tagCount() > 1)
			{
				s = this.bookPages.getStringTagAt(this.bookPages.tagCount() - 1);
				System.out.println(s);
				if(s.length() != 0)
				{
					break;
				}

				this.bookPages.removeTag(this.bookPages.tagCount() - 1);
			}

			if(!this.bookObj.hasTagCompound())
			{
				NBTTagCompound nbttagcompound = this.bookObj.getTagCompound();
				nbttagcompound.setTag("pages", this.bookPages);
			}
			else
			{
				this.bookObj.setTagInfo("pages", this.bookPages);
			}

			if(bookObj.getTagCompound().getString("author") == null || bookObj.getTagCompound().getString("author").equalsIgnoreCase(""))
			{
				this.bookObj.setTagInfo("author", new NBTTagString(this.editingPlayer.getUniqueID().toString()));
				this.bookObj.setTagInfo("authorName", new NBTTagString(this.editingPlayer.getCommandSenderEntity().getName()));
				this.bookObj.setTagInfo("title", new NBTTagString(this.bookTitle.trim()));
			}

			NBTTagCompound tags = new NBTTagCompound();
			tags.setByte("id", (byte) 1);
			tags.setString("editor", editingPlayer.getCommandSenderEntity().getName());
			NBTTagCompound itemTags = new NBTTagCompound();
			itemTags.setShort("ItemID", (short) Item.getIdFromItem(this.bookObj.getItem()));
			itemTags.setByte("ItemStackSize", (byte) this.bookObj.stackSize);
			itemTags.setShort("ItemDamage", (short) this.bookObj.getItemDamage());

			tags.setTag("ItemData", itemTags);
			tags.setTag("ItemTags", this.bookObj.getTagCompound());

			NetworkManager.getSimpleNetwork(TurkeyUtil.instance).sendToServer(new UtilPacket(tags));
		}
	}

	protected void actionPerformed(GuiButton p_146284_1_)
	{
		if(p_146284_1_.enabled)
		{
			if(p_146284_1_.id == 0)
			{
				this.mc.displayGuiScreen((GuiScreen) null);
				this.sendBookToServer();
				if(!this.bookisAuthored)
				{
					System.out.println("Title Set");
					this.bookisAuthored = true;
				}
			}
			else if(p_146284_1_.id == 1)
			{
				if(this.currPage < this.bookTotalPages - 1)
				{
					++this.currPage;
				}
				else if(this.bookisAuthored)
				{
					this.addNewPage();

					if(this.currPage < this.bookTotalPages - 1)
					{
						++this.currPage;
					}
				}
			}
			else if(p_146284_1_.id == 2)
			{
				if(this.currPage > 0)
				{
					--this.currPage;
				}
			}
			else if(p_146284_1_.id == 3)
			{
				this.mc.displayGuiScreen((GuiScreen) null);
			}

			this.updateButtons();
		}
	}

	private void addNewPage()
	{
		if(this.bookPages != null && this.bookPages.tagCount() < 50)
		{
			this.bookPages.appendTag(new NBTTagString(""));
			++this.bookTotalPages;
		}
	}

	/**
	 * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
	 * 
	 * @throws IOException
	 */
	protected void keyTyped(char p_73869_1_, int p_73869_2_) throws IOException
	{
		super.keyTyped(p_73869_1_, p_73869_2_);

		System.out.println(this.getBookAuthor() + " " + editingPlayer.getUniqueID().toString());
		if(!this.bookisAuthored || this.getBookAuthor().equalsIgnoreCase(editingPlayer.getUniqueID().toString()))
		{
			if(!this.bookisAuthored)
			{
				this.func_146460_c(p_73869_1_, p_73869_2_);
			}
			else
			{
				this.keyTypedInBook(p_73869_1_, p_73869_2_);
			}
		}
	}

	/**
	 * Processes keystrokes when editing the text of a book
	 */
	private void keyTypedInBook(char p_146463_1_, int p_146463_2_)
	{
		switch(p_146463_1_)
		{
			case 22:
				this.func_146459_b(GuiScreen.getClipboardString());
				return;
			default:
				switch(p_146463_2_)
				{
					case 14:
						String s = this.func_146456_p();

						if(s.length() > 0)
						{
							this.func_146457_a(s.substring(0, s.length() - 1));
						}

						return;
					case 28:
					case 156:
						this.func_146459_b("\n");
						return;
					default:
						if(ChatAllowedCharacters.isAllowedCharacter(p_146463_1_))
						{
							this.func_146459_b(Character.toString(p_146463_1_));
						}
				}
		}
	}

	private void func_146460_c(char p_146460_1_, int p_146460_2_)
	{
		switch(p_146460_2_)
		{
			case 14:
				if(!this.bookTitle.isEmpty())
				{
					this.bookTitle = this.bookTitle.substring(0, this.bookTitle.length() - 1);
					this.updateButtons();
				}

				return;
			case 28:
			case 156:
				if(!this.bookTitle.isEmpty())
				{
					this.sendBookToServer();
					this.mc.displayGuiScreen((GuiScreen) null);
				}

				return;
			default:
				if(this.bookTitle.length() < 16 && ChatAllowedCharacters.isAllowedCharacter(p_146460_1_))
				{
					this.bookTitle = this.bookTitle + Character.toString(p_146460_1_);
					this.updateButtons();
				}
		}
	}

	private String func_146456_p()
	{
		return this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.tagCount() ? this.bookPages.getStringTagAt(this.currPage) : "";
	}

	private void func_146457_a(String p_146457_1_)
	{
		if(this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.tagCount())
		{
			this.bookPages.set(this.currPage, new NBTTagString(p_146457_1_));
		}
	}

	private void func_146459_b(String p_146459_1_)
	{
		String s1 = this.func_146456_p();
		String s2 = s1 + p_146459_1_;
		int i = this.fontRendererObj.splitStringWidth(s2 + "" + ChatFormatting.BLACK + "_", 118);

		if(i <= 118 && s2.length() < 256)
		{
			this.func_146457_a(s2);
		}
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(bookGuiTextures);
		int k = (this.width - this.bookImageWidth) / 2;
		byte b0 = 2;
		this.drawTexturedModalRect(k, b0, 0, 0, this.bookImageWidth, this.bookImageHeight);
		String s;
		String s1;
		int l;

		if(!this.bookisAuthored)
		{
			s = this.bookTitle;

			s1 = I18n.format("book.editTitle", new Object[0]);
			l = this.fontRendererObj.getStringWidth(s1);
			this.fontRendererObj.drawString(s1, k + 36 + (116 - l) / 2, b0 + 16 + 16, 0);
			int i1 = this.fontRendererObj.getStringWidth(s);
			this.fontRendererObj.drawString(s, k + 36 + (116 - i1) / 2, b0 + 48, 0);
			String s2 = I18n.format("book.byAuthor", new Object[] { this.editingPlayer.getCommandSenderEntity() });
			int j1 = this.fontRendererObj.getStringWidth(s2);
			this.fontRendererObj.drawString(ChatFormatting.DARK_GRAY + s2, k + 36 + (116 - j1) / 2, b0 + 48 + 10, 0);
			String s3 = I18n.format("book.finalizeWarning", new Object[0]);
			this.fontRendererObj.drawSplitString(s3, k + 36, b0 + 80, 116, 0);
		}
		else
		{
			s = I18n.format("book.pageIndicator", new Object[] { Integer.valueOf(this.currPage + 1), Integer.valueOf(this.bookTotalPages) });
			s1 = "";

			if(this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.tagCount())
			{
				s1 = this.bookPages.getStringTagAt(this.currPage);
			}

			if(this.bookisAuthored)
			{
				if(this.fontRendererObj.getBidiFlag())
				{
					s1 = s1 + "_";
				}
				else if(this.updateCount / 6 % 2 == 0)
				{
					s1 = s1 + "" + ChatFormatting.BLACK + "_";
				}
				else
				{
					s1 = s1 + "" + ChatFormatting.GRAY + "_";
				}
			}

			l = this.fontRendererObj.getStringWidth(s);
			this.fontRendererObj.drawString(s, k - l + this.bookImageWidth - 44, b0 + 16, 0);
			this.fontRendererObj.drawSplitString(s1, k + 36, b0 + 16 + 16, 116, 0);
		}

		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
	}

	@SideOnly(Side.CLIENT)
	static class NextPageButton extends GuiButton
	{
		private final boolean field_146151_o;

		public NextPageButton(int p_i1079_1_, int p_i1079_2_, int p_i1079_3_, boolean p_i1079_4_)
		{
			super(p_i1079_1_, p_i1079_2_, p_i1079_3_, 23, 13, "");
			this.field_146151_o = p_i1079_4_;
		}

		/**
		 * Draws this button to the screen.
		 */
		public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
		{
			if(this.visible)
			{
				boolean flag = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				p_146112_1_.getTextureManager().bindTexture(BetterBookGui.bookGuiTextures);
				int k = 0;
				int l = 192;

				if(flag)
				{
					k += 23;
				}

				if(!this.field_146151_o)
				{
					l += 13;
				}

				this.drawTexturedModalRect(this.xPosition, this.yPosition, k, l, 23, 13);
			}
		}
	}

	public String getBookAuthor()
	{
		if(this.bookObj.hasTagCompound())
			return this.bookObj.getTagCompound().getString("author");
		return "";
	}
}