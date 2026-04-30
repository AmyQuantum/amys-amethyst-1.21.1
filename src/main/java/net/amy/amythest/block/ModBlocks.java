package net.amy.amythest.block;

import net.amy.amythest.AmysAmethyst;
import net.amy.amythest.particle.AmethystFlameParticle;
import net.amy.amythest.particle.ModParticles;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(AmysAmethyst.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(AmysAmethyst.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        AmysAmethyst.LOGGER.info("registering Mod Blocks for " + AmysAmethyst.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.AMETHYST_BRICKS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.AMETHYST_BRICK_SLAB);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.AMETHYST_BRICK_STAIRS);
        });



        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.AMETHYST_INFUSED_STONE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.AMETHYST_INFUSED_DEEPSLATE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.AMETHYST_LANTERN);
        });
    }

    public static final Block AMETHYST_BRICKS = registerBlock("amethyst_bricks",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block AMETHYST_INFUSED_STONE = registerBlock("amethyst_infused_stone",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block AMETHYST_INFUSED_DEEPSLATE = registerBlock("amethyst_infused_deepslate",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));


    public static final Block AMETHYST_BRICK_STAIRS = registerBlock("amethyst_brick_stairs",
            new StairsBlock(ModBlocks.AMETHYST_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block AMETHYST_LANTERN = registerBlock("amethyst_lantern", new LanternBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).solid().requiresTool().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance(state -> 15).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block AMETHYST_BRICK_SLAB = registerBlock("amethyst_brick_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block AMETHYST_TORCH = registerBlock("amethyst_torch", new TorchBlock(ModParticles.AMETHYST_FLAME, AbstractBlock.Settings.create().sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 15).breakInstantly().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block AMETHYST_WALL_TORCH = registerBlock("amethyst_wall_torch", new WallTorchBlock(ModParticles.AMETHYST_FLAME, AbstractBlock.Settings.create().noCollision().breakInstantly().luminance(state -> 15).sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).dropsLike(AMETHYST_TORCH).pistonBehavior(PistonBehavior.DESTROY)));

}
