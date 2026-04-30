package net.amy.amythest.entity;

import net.amy.amythest.AmysAmethyst;
import net.amy.amythest.AmysAmethystClient;
import net.amy.amythest.entity.custom.CherryFoxEntity;

import net.amy.amythest.entity.projectile.AmethystArrowEntity;
import net.amy.amythest.entity.projectile.AmethystTridentEntity;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.WorldAccess;

import static net.amy.amythest.AmysAmethyst.MOD_ID;

public class ModEntityType {

    public static final EntityType<CherryFoxEntity> CHERRY_FOX = register(
            "cherry_fox",
            EntityType.Builder.create(CherryFoxEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.6F, 0.7F)
                    .eyeHeight(0.4F)
                    .passengerAttachments(new Vec3d(0.0, 0.6375, -0.25))
                    .maxTrackingRange(8)
                    .allowSpawningInside(Blocks.SWEET_BERRY_BUSH)

    );

    public static final EntityType<AmethystArrowEntity> AMETHYST_ARROW = register(
            "amethyst_arrow",
            EntityType.Builder.<AmethystArrowEntity>create(AmethystArrowEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
    );

    public static final EntityType<AmethystTridentEntity> AMETHYST_TRIDENT = register(
            "amethyst_trident",
            EntityType.Builder.<AmethystTridentEntity>create(AmethystTridentEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
    );




    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, Identifier.of(MOD_ID, name), type.build(name));
    }

    public static void registerModEntityType() {
        AmysAmethyst.LOGGER.info("Registering Mod Entities for " + MOD_ID);
    }
}



