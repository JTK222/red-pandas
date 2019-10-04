package com.mcmoddev.redpandas.common.entities;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RedPandaEntity extends EntityAnimal {

    // TODO: Find or make 1.12 replacement for bamboo
    //private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.BAMBOO);

    public RedPandaEntity(World world) {
        super(world);
        this.setSize(0.90F, 0.60F);
    }

    @Override
    protected void initEntityAI() {
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        //tasks.addTask(2, new EntityAIBreed(this, 1.0D));
        //tasks.addTask(3, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
        tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
        tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        tasks.addTask(7, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        //TODO Edit or make some sounds for this mob so that we don't rely on the vanilla panda (Sounds too big/rough not small and cute)
        return null;// SoundEvents.ENTITY_PANDA_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return null;// SoundEvents.ENTITY_PANDA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;// SoundEvents.ENTITY_PANDA_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block block) {
        super.playStepSound(pos, block);
        //playSound(SoundEvents.ENTITY_PANDA_STEP, 0.10F, 2.0F);
    }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageableEntity) {
        return new RedPandaEntity(world);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
        //return TEMPTATION_ITEMS.test(stack);
    }


}
