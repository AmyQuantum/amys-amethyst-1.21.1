package net.amy.amythest.client.render;

import net.amy.amythest.client.render.entity.AmethystTridentEntityRenderer;
import net.amy.amythest.client.render.entity.model.AmethystTridentEntityModel;
import net.amy.amythest.entity.projectile.AmethystTridentEntity;
import net.amy.amythest.mixin.ItemRendererMixin;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry.DynamicItemRenderer;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import static net.amy.amythest.AmysAmethyst.MOD_ID;
import static net.minecraft.client.render.entity.model.EntityModelLayers.TRIDENT;

public class AmethystTridentItemRenderer implements SimpleSynchronousResourceReloadListener, DynamicItemRenderer {



    private AmethystTridentEntityModel modelAmethystTrident;

    public static final ModelIdentifier AMETHYST_TRIDENT_MODEL_IDENTIFIER = ModelIdentifier.ofInventoryVariant(Identifier.of(MOD_ID, "amethyst_trident"));

    public static final AmethystTridentItemRenderer INSTANCE = new AmethystTridentItemRenderer();
    public AmethystTridentItemRenderer() {
    }


    @Override
    public Identifier getFabricId() {
        return Identifier.of(MOD_ID);
    }







    @Override
    public void reload(ResourceManager manager) {
        this.modelAmethystTrident = new AmethystTridentEntityModel(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(TRIDENT));
    }




    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        Item item = stack.getItem();
        matrices.push();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer2 = ItemRenderer.getDirectItemGlintConsumer(
                vertexConsumers, this.modelAmethystTrident.getLayer(AmethystTridentEntityModel.TEXTURE), false, stack.hasGlint()
        );
        this.modelAmethystTrident.render(matrices, vertexConsumer2, light, overlay);
        matrices.pop();
    }


}


