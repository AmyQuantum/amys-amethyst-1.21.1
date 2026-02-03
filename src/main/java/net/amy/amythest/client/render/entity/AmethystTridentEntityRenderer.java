package net.amy.amythest.client.render.entity;

import net.amy.amythest.AmysAmethyst;
import net.amy.amythest.client.render.entity.model.AmethystTridentEntityModel;
import net.amy.amythest.entity.projectile.AmethystTridentEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class AmethystTridentEntityRenderer extends EntityRenderer<AmethystTridentEntity> {
	public static final Identifier TEXTURE = Identifier.of(AmysAmethyst.MOD_ID, "textures/entity/amethyst_trident.png");
	private final AmethystTridentEntityModel model;

	public AmethystTridentEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
		this.model = new AmethystTridentEntityModel(context.getPart(EntityModelLayers.TRIDENT));
	}

	public void render(AmethystTridentEntity amethystTridentEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
		matrixStack.push();
		matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(g, amethystTridentEntity.prevYaw, amethystTridentEntity.getYaw()) - 90.0F));
		matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(g, amethystTridentEntity.prevPitch, amethystTridentEntity.getPitch()) + 90.0F));
		VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(
			vertexConsumerProvider, this.model.getLayer(this.getTexture(amethystTridentEntity)), false, amethystTridentEntity.isEnchanted()
		);
		this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV);
		matrixStack.pop();
		super.render(amethystTridentEntity, f, g, matrixStack, vertexConsumerProvider, i);
	}

	public Identifier getTexture(AmethystTridentEntity amethystTridentEntity) {
		return TEXTURE;
	}
}

