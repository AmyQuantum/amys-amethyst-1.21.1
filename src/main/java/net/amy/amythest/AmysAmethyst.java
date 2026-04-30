package net.amy.amythest;

import net.amy.amythest.block.ModBlocks;
import net.amy.amythest.effect.ModEffects;
import net.amy.amythest.entity.ModEntityType;
import net.amy.amythest.entity.custom.CherryFoxEntity;
import net.amy.amythest.item.ModItemGroups;
import net.amy.amythest.item.ModItems;

import net.amy.amythest.particle.ModParticles;
import net.amy.amythest.util.ModLootTableModifiers;
import net.amy.amythest.world.gen.ModOreGeneration;
import net.amy.amythest.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmysAmethyst implements ModInitializer {
	public static final String MOD_ID = "amythest";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEffects.registerEffects();
		ModEntityType.registerModEntityType();
		ModWorldGeneration.generateModWorldGen();
		ModLootTableModifiers.modifyLootTables();
		ModParticles.registerParticles();

		FabricDefaultAttributeRegistry.register(ModEntityType.CHERRY_FOX, CherryFoxEntity.createAttributes());


	}
}