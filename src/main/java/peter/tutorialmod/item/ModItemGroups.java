package peter.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import peter.tutorialmod.TutorialMod;
import peter.tutorialmod.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup EMERALD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "tutorialmod"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.tutorialmod"))
                    .icon(() -> new ItemStack(Items.DIAMOND)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RIFLE);
                        entries.add(ModItems.BULLET);
                        entries.add(ModItems.EMERALD_SWORD);
                        entries.add(ModItems.EMERALD_PICKAXE);
                        entries.add(ModItems.EMERALD_AXE);
                        entries.add(ModItems.EMERALD_SHOVEL);
                        entries.add(ModBlocks.CHEESE_BLOCK);
                    }).build());


    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }

}
