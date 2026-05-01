package net.amy.amythest.datagen;
import net.amy.amythest.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.amy.amythest.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.CampfireBlock;
import net.minecraft.data.client.*;

import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

import static net.amy.amythest.AmysAmethyst.MOD_ID;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {

        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMETHYST_INFUSED_DEEPSLATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMETHYST_INFUSED_STONE);
        BlockStateModelGenerator.BlockTexturePool amethystBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AMETHYST_BRICKS);

        amethystBricksPool.stairs(ModBlocks.AMETHYST_BRICK_STAIRS);
        amethystBricksPool.slab(ModBlocks.AMETHYST_BRICK_SLAB);

        blockStateModelGenerator.registerLantern(ModBlocks.AMETHYST_LANTERN);
        blockStateModelGenerator.registerTorch(ModBlocks.AMETHYST_TORCH, ModBlocks.AMETHYST_WALL_TORCH);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMETHYST_SAND);

    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.AMETHYST_SCYTHE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_GLAIVE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.AMETHYST_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_BOOTS));

        itemModelGenerator.register(ModItems.AMETHYST_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHERRY_FOX_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        }

    }
