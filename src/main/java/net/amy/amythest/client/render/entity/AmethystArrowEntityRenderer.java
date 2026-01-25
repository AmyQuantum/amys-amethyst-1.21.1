package net.amy.amythest.client.render.entity;

import net.amy.amythest.AmysAmethyst;
import net.amy.amythest.entity.projectile.AmethystArrowEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class AmethystArrowEntityRenderer extends ProjectileEntityRenderer<AmethystArrowEntity> {
	public static final Identifier TEXTURE = Identifier.of(AmysAmethyst.MOD_ID, "textures/entity/projectiles/amethyst_arrow.png");

	public AmethystArrowEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
	}

	public Identifier getTexture(AmethystArrowEntity amethystArrowEntity) {
		return TEXTURE;
	}
}
