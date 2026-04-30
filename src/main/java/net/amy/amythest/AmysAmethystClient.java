package net.amy.amythest;


import com.mojang.blaze3d.systems.RenderSystem;
import net.amy.amythest.block.ModBlocks;
import net.amy.amythest.client.render.AmethystTridentItemRenderer;
import net.amy.amythest.client.render.entity.AmethystArrowEntityRenderer;
import net.amy.amythest.client.render.entity.AmethystTridentEntityRenderer;
import net.amy.amythest.effect.ModEffects;
import net.amy.amythest.entity.ModEntityType;
import net.amy.amythest.entity.client.CherryFoxEntityModel;
import net.amy.amythest.entity.client.CherryFoxEntityRenderer;
import net.amy.amythest.particle.AmethystFlameParticle;
import net.amy.amythest.particle.ModParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;

import static net.amy.amythest.AmysAmethyst.MOD_ID;
import static net.amy.amythest.item.ModItems.AMETHYST_TRIDENT;

//public static final AmethystTridentItemRenderer INSTANCE = new AmethystTridentItemRenderer(this.entityModelLoader.getModelPart(EntityModelLayers.TRIDENT));
public class AmysAmethystClient implements ClientModInitializer {


    private static final Identifier CRYSTALLISATION_OVERLAY = Identifier.of(MOD_ID, "textures/misc/crystallisation_outline.png");

    public static void registerModelPredicateProviders() {

        ModelPredicateProviderRegistry.register(AMETHYST_TRIDENT, Identifier.ofVanilla( "throwing"), (itemStack, clientWorld, livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
    }

    private void renderOverlay(DrawContext context, Identifier texture, float opacity) {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        context.setShaderColor(1.0F, 1.0F, 1.0F, opacity);
        context.drawTexture(
                texture,
                0,
                0,
                -90,
                0.0F,
                0.0F,
                context.getScaledWindowWidth(),
                context.getScaledWindowHeight(),
                context.getScaledWindowWidth(),
                context.getScaledWindowHeight()
        );
        }


    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntityType.AMETHYST_ARROW, AmethystArrowEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityType.AMETHYST_TRIDENT, AmethystTridentEntityRenderer::new);
        BuiltinItemRendererRegistry.INSTANCE.register( AMETHYST_TRIDENT, AmethystTridentItemRenderer.INSTANCE);
        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(AmethystTridentItemRenderer.INSTANCE);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMETHYST_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMETHYST_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMETHYST_WALL_TORCH, RenderLayer.getCutout());
        registerModelPredicateProviders();

            HudRenderCallback.EVENT.register((context, tickDelta) -> {
                MinecraftClient client = MinecraftClient.getInstance();
                if (client.player.hasStatusEffect(ModEffects.CRYSTALLISATION)) {
                    if (MinecraftClient.getInstance().currentScreen == null) {
                        renderOverlay(context, CRYSTALLISATION_OVERLAY, 1);
                    }
                }
            });
        EntityModelLayerRegistry.registerModelLayer(CherryFoxEntityModel.CHERRY_FOX, CherryFoxEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntityType.CHERRY_FOX, CherryFoxEntityRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.AMETHYST_FLAME, AmethystFlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.AMETHYST_FLAME, AmethystFlameParticle.SmallFactory::new);



        }
}
