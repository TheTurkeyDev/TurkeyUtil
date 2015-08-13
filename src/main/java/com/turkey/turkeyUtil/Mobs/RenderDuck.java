package com.turkey.turkeyUtil.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDuck extends RenderLiving
{
    private static final ResourceLocation duckTextures = new ResourceLocation("turkeyutil:textures/entity/Duck.png");

    public RenderDuck(ModelBase p_i1252_1_, float p_i1252_2_)
    {
        super(p_i1252_1_, p_i1252_2_);
    }

    protected ResourceLocation getEntityTexture(EntityDuck p_110775_1_)
    {
        return duckTextures;
    }

    protected float handleRotationFloat(EntityDuck p_77044_1_, float p_77044_2_)
    {
        float f1 = p_77044_1_.field_70888_h + (p_77044_1_.field_70886_e - p_77044_1_.field_70888_h) * p_77044_2_;
        float f2 = p_77044_1_.field_70884_g + (p_77044_1_.destPos - p_77044_1_.field_70884_g) * p_77044_2_;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    protected float handleRotationFloat(EntityLivingBase p_77044_1_, float p_77044_2_)
    {
        return this.handleRotationFloat((EntityDuck)p_77044_1_, p_77044_2_);
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityDuck)p_110775_1_);
    }
}