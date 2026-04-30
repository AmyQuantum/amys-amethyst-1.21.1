package net.amy.amythest.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FoxEntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.FoxHeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.FoxEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

import static net.amy.amythest.AmysAmethyst.MOD_ID;

@Environment(EnvType.CLIENT)
public class CherryFoxEntityRenderer extends MobEntityRenderer<FoxEntity, FoxEntityModel<FoxEntity>> {
    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/fox/cherry_fox.png");
    private static final Identifier SLEEPING_TEXTURE = Identifier.of(MOD_ID, "textures/entity/fox/cherry_fox_sleep.png");

    public CherryFoxEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new FoxEntityModel<>(context.getPart(EntityModelLayers.FOX)), 0.4F);
        this.addFeature(new FoxHeldItemFeatureRenderer(this, context.getHeldItemRenderer()));
    }

    protected void setupTransforms(FoxEntity foxEntity, MatrixStack matrixStack, float f, float g, float h, float i) {
        super.setupTransforms(foxEntity, matrixStack, f, g, h, i);
        if (foxEntity.isChasing() || foxEntity.isWalking()) {
            float j = -MathHelper.lerp(h, foxEntity.prevPitch, foxEntity.getPitch());
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(j));
        }
    }

    public Identifier getTexture(FoxEntity foxEntity) {
            return foxEntity.isSleeping() ? SLEEPING_TEXTURE : TEXTURE;
    }
}
