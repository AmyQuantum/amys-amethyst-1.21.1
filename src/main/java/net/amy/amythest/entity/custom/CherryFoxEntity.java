package net.amy.amythest.entity.custom;

import net.amy.amythest.entity.ModEntityType;
import net.amy.amythest.registry.tag.ModBiomeTags;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

public class CherryFoxEntity extends FoxEntity{



    private static final TrackedData<Optional<UUID>> OWNER = DataTracker.registerData(CherryFoxEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
    private static final TrackedData<Optional<UUID>> OTHER_TRUSTED = DataTracker.registerData(CherryFoxEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);

    public CherryFoxEntity(EntityType<? extends FoxEntity> entityType, World world) {
        super(entityType, world);

    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5F)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 12.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE, 6.0);
    }

    @Override
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
        if (random.nextFloat() < 0.2F) {
            float f = random.nextFloat();
            ItemStack itemStack;
            if (f < 0.05F) {
                itemStack = new ItemStack(Items.EMERALD);
            } else if (f < 0.2F) {
                itemStack = new ItemStack(Items.CHERRY_LEAVES);
            } else if (f < 0.4F) {
                itemStack = random.nextBoolean() ? new ItemStack(Items.RABBIT_FOOT) : new ItemStack(Items.RABBIT_HIDE);
            } else if (f < 0.6F) {
                itemStack = new ItemStack(Items.SWEET_BERRIES);
            } else if (f < 0.8F) {
                itemStack = new ItemStack(Items.AMETHYST_SHARD);
            } else {
                itemStack = new ItemStack(Items.CHERRY_SAPLING);
            }

            this.equipStack(EquipmentSlot.MAINHAND, itemStack);
        }
    }

    @Override
    public CherryFoxEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        CherryFoxEntity cherryFoxEntity = ModEntityType.CHERRY_FOX.create(serverWorld);
        if (cherryFoxEntity != null) {
            cherryFoxEntity.setVariant(this.random.nextBoolean() ? this.getVariant() : ((CherryFoxEntity)passiveEntity).getVariant());
        }

        return cherryFoxEntity;
    }

    void addTrustedUuid(@Nullable UUID uuid) {
        if (this.dataTracker.get(OWNER).isPresent()) {
            this.dataTracker.set(OTHER_TRUSTED, Optional.ofNullable(uuid));
        } else {
            this.dataTracker.set(OWNER, Optional.ofNullable(uuid));
        }
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(OWNER, Optional.empty());
        builder.add(OTHER_TRUSTED, Optional.empty());
    }


    public static boolean canSpawnCherry(EntityType<CherryFoxEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isIn(BlockTags.FOXES_SPAWNABLE_ON) && isLightLevelValidForNaturalSpawn(world, pos);
    }


    class CherryMateGoal extends AnimalMateGoal {
        public CherryMateGoal(AnimalEntity animal, double speed) {
            super(animal, speed);
        }

        @Override
        protected void breed() {
            ServerWorld serverWorld = (ServerWorld)this.world;
            CherryFoxEntity cherryFoxEntity = (CherryFoxEntity) this.animal.createChild(serverWorld, this.mate);
            if (cherryFoxEntity != null) {
                ServerPlayerEntity serverPlayerEntity = this.animal.getLovingPlayer();
                ServerPlayerEntity serverPlayerEntity2 = this.mate.getLovingPlayer();
                ServerPlayerEntity serverPlayerEntity3 = serverPlayerEntity;
                if (serverPlayerEntity != null) {
                    cherryFoxEntity.addTrustedUuid(serverPlayerEntity.getUuid());
                } else {
                    serverPlayerEntity3 = serverPlayerEntity2;
                }

                if (serverPlayerEntity2 != null && serverPlayerEntity != serverPlayerEntity2) {
                    cherryFoxEntity.addTrustedUuid(serverPlayerEntity2.getUuid());
                }

                if (serverPlayerEntity3 != null) {
                    serverPlayerEntity3.incrementStat(Stats.ANIMALS_BRED);
                    Criteria.BRED_ANIMALS.trigger(serverPlayerEntity3, this.animal, this.mate, cherryFoxEntity);
                }

                this.animal.setBreedingAge(6000);
                this.mate.setBreedingAge(6000);
                this.animal.resetLoveTicks();
                this.mate.resetLoveTicks();
                cherryFoxEntity.setBreedingAge(-24000);
                cherryFoxEntity.refreshPositionAndAngles(this.animal.getX(), this.animal.getY(), this.animal.getZ(), 0.0F, 0.0F);
                serverWorld.spawnEntityAndPassengers(cherryFoxEntity);
                this.world.sendEntityStatus(this.animal, EntityStatuses.ADD_BREEDING_PARTICLES);
                if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
                    this.world
                            .spawnEntity(new ExperienceOrbEntity(this.world, this.animal.getX(), this.animal.getY(), this.animal.getZ(), this.animal.getRandom().nextInt(7) + 1));
                }
            }
        }
    }

}

