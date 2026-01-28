package net.amy.amythest;


import net.amy.amythest.client.render.entity.AmethystArrowEntityRenderer;
import net.amy.amythest.client.render.entity.AmethystTridentEntityRenderer;
import net.amy.amythest.entity.ModEntityType;
import net.amy.amythest.entity.projectile.AmethystArrowEntity;
import net.amy.amythest.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.resource.ResourceType;
import net.minecraft.client.MinecraftClient;


public class AmysAmethystClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntityType.AMETHYST_ARROW, AmethystArrowEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityType.AMETHYST_TRIDENT, AmethystTridentEntityRenderer::new);
    }
}