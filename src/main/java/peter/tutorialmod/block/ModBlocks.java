package peter.tutorialmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import peter.tutorialmod.TutorialMod;

public class ModBlocks {

    public static final Block CHEESE_BLOCK = registerBlock("cheese_block",
            new Block(FabricBlockSettings.copyOf(Blocks.HONEY_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering mod blocks");
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }



}
