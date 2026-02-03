package net.amy.amythest.entity.projectile;

import net.amy.amythest.effect.ModEffects;
import net.amy.amythest.entity.ModEntityType;
import net.amy.amythest.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AmethystArrowEntity extends PersistentProjectileEntity {
	private int duration = 200;



	public AmethystArrowEntity(World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
		super(ModEntityType.AMETHYST_ARROW, owner, world, stack, shotFrom);
	}

	public AmethystArrowEntity(World world, double x, double y, double z, ItemStack stack, @Nullable ItemStack shotFrom) {
		super(ModEntityType.AMETHYST_ARROW, x, y, z, world, stack, shotFrom);
	}

	public AmethystArrowEntity(EntityType<AmethystArrowEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.getWorld().isClient && !this.inGround) {
			this.getWorld().addParticle(ParticleTypes.FALLING_OBSIDIAN_TEAR, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
		}
	}

	@Override
	protected void onHit(LivingEntity target) {
		super.onHit(target);
		StatusEffectInstance statusEffectInstance = new StatusEffectInstance(ModEffects.CRYSTALLISATION, this.duration, 1);
		target.addStatusEffect(statusEffectInstance, this.getEffectCause());
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		if (nbt.contains("Duration")) {
			this.duration = nbt.getInt("Duration");
		}
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("Duration", this.duration);
	}

	@Override
	protected ItemStack getDefaultItemStack() {
		return new ItemStack(ModItems.AMETHYST_ARROW);
	}
}
