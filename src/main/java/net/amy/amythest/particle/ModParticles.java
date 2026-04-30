package net.amy.amythest.particle;

import net.amy.amythest.AmysAmethyst;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.amy.amythest.AmysAmethyst.MOD_ID;

public class ModParticles {

    public static final SimpleParticleType AMETHYST_FLAME =
            registerParticle("amethyst_flame", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        AmysAmethyst.LOGGER.info("Registering Particles for: " + MOD_ID);
    }
}
