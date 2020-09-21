package cat.tophat.redpandas.common.entities;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

public class RedPandaEntity extends EntityAnimal {

    private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(Items.REEDS);

    public RedPandaEntity(World world) {
        super(world);
        this.setSize(0.90F, 0.60F);
    }

    @Override
    protected void initEntityAI() {
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        tasks.addTask(2, new EntityAIMate(this, 1.0D));
        tasks.addTask(3, new EntityAITempt(this, 1.2D, false, TEMPTATION_ITEMS));
        tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
        tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        tasks.addTask(7, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3F);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
        //return SoundEvents.ENTITY_PANDA_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource source) {
        return null;
        //return SoundEvents.ENTITY_PANDA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
        //return SoundEvents.ENTITY_PANDA_DEATH;
    }

    @Override
    protected void playStepSound(@Nonnull BlockPos pos, @Nonnull Block block) {
        super.playStepSound(pos, block);
        //playSound(SoundEvents.ENTITY_PANDA_STEP, 0.10F, 2.0F);
    }

    @Nullable
    @Override
    public EntityAgeable createChild(@Nonnull EntityAgeable ageableEntity) {
        return new RedPandaEntity(world);
    }

    @Override
    public boolean isBreedingItem(@Nonnull ItemStack stack) {
        return TEMPTATION_ITEMS.contains(stack.getItem());
    }
}
