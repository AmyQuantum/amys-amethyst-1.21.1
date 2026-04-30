package net.amy.amythest.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;

public class AmethystFlameParticle extends AbstractSlowingParticle {
    AmethystFlameParticle(ClientWorld clientWorld, double x, double y, double z, SpriteProvider spriteProvider,
                          double xSpeed, double ySpeed, double zSpeed) {
        super(clientWorld, x, y ,z, xSpeed, ySpeed, zSpeed);
        this.setSpriteForAge(spriteProvider);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void move(double dx, double dy, double dz) {
        this.setBoundingBox(this.getBoundingBox().offset(dx, dy, dz));
        this.repositionFromBoundingBox();
    }

    @Override
    public float getSize(float tickDelta) {
        float f = ((float) this.age + tickDelta) / (float) this.maxAge;
        return this.scale * (1.0f - f * f * 0.5f);
    }

    @Override
    public int getBrightness(float tint) {
        float f = ((float) this.age + tint) / (float) this.maxAge;
        f = MathHelper.clamp(f, 0.0f, 1.0f);
        int i = super.getBrightness(tint);
        int j = i & 0xFF;
        int k = i >> 16 & 0xFF;
        if ((j += (int) (f * 15.0f * 16.0f)) > 240) {
            j = 240;
        }
        return j | k << 16;
    }
    public static class SmallFactory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public SmallFactory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(SimpleParticleType simpleParticleType, ClientWorld clientWorld,double x, double y, double z,
                                       double xSpeed, double ySpeed, double zSpeed) {
            AmethystFlameParticle amethystFlameParticle = new AmethystFlameParticle(clientWorld, x, y ,z, this.spriteProvider, xSpeed, ySpeed, zSpeed);
            amethystFlameParticle.setSprite(this.spriteProvider);
            amethystFlameParticle.scale(0.5f);
            return amethystFlameParticle;
        }
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {

            this.spriteProvider = spriteProvider;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType simpleParticleType, ClientWorld clientWorld, double x, double y, double z,
                                       double xSpeed, double ySpeed, double zSpeed) {
            AmethystFlameParticle amethystFlameParticle = new AmethystFlameParticle(clientWorld, x, y ,z, this.spriteProvider, xSpeed, ySpeed, zSpeed);
            amethystFlameParticle.setSprite(this.spriteProvider);
            return amethystFlameParticle;
        }
    }
}