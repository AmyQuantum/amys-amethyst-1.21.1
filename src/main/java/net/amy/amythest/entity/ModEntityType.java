package net.amy.amythest.entity;

import net.amy.amythest.AmysAmethyst;
import net.amy.amythest.entity.projectile.AmethystArrowEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntityType {



    public static final EntityType<AmethystArrowEntity> AMETHYST_ARROW = register(
            "amethyst_arrow",
            EntityType.Builder.<AmethystArrowEntity>create(AmethystArrowEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
    );

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, Identifier.of(AmysAmethyst.MOD_ID, name), type.build(name));
    }


}
