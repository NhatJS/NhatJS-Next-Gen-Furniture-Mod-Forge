package net.nhatjs.nextgen_furniture.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;
import net.nhatjs.nextgen_furniture.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NhatJSNextGenFurnitureMod.MOD_ID);


    public static final RegistryObject<CreativeModeTab> NEXT_GEN_FURNITURE_TAB = CREATIVE_MODE_TABS.register("next_gen_furniture_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NEXTGEN_FURNITURE_LOGO.get()))
                    .title(Component.translatable("itemgroup.nextgen_furniture.nextgen_furniture_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.CHAIR_WHITE.get());
                        pOutput.accept(ModBlocks.CHAIR_WOOD_OAK.get());
                        pOutput.accept(ModBlocks.CHAIR_WOOD_BIRCH.get());
                        pOutput.accept(ModBlocks.CHAIR_2_WHITE_GRAY.get());
                        pOutput.accept(ModBlocks.CHAIR_2_WHITE_WHITE.get());
                        pOutput.accept(ModBlocks.CHAIR_2_WOOD_OAK_GRAY.get());
                        pOutput.accept(ModBlocks.CHAIR_2_WOOD_OAK_WHITE.get());
                        pOutput.accept(ModBlocks.CHAIR_2_WOOD_BIRCH_GRAY.get());
                        pOutput.accept(ModBlocks.CHAIR_2_WOOD_BIRCH_WHITE.get());
                        pOutput.accept(ModBlocks.TABLE_1X1_BLACK.get());
                        pOutput.accept(ModBlocks.TABLE_1X1_WHITE.get());
                        pOutput.accept(ModBlocks.TABLE_2X1_BLACK.get());
                        pOutput.accept(ModBlocks.TABLE_2X1_WHITE.get());
                        pOutput.accept(ModBlocks.TABLE_3X1_BLACK.get());
                        pOutput.accept(ModBlocks.TABLE_3X1_WHITE.get());
                        pOutput.accept(ModBlocks.COFFEE_TABLE_WHITE.get());
                        pOutput.accept(ModBlocks.TABLE_DINING_WHITE.get());
                        pOutput.accept(ModBlocks.TABLE_DINING_WOOD_OAK.get());
                        pOutput.accept(ModBlocks.TABLE_DINING_WOOD_BIRCH.get());
                        pOutput.accept(ModBlocks.TV_STAND_WOOD_OAK.get());
                        pOutput.accept(ModBlocks.TV_STAND_WOOD_BIRCH.get());
                        pOutput.accept(ModBlocks.BED_GRAY_WOOD_OAK.get());
                        pOutput.accept(ModBlocks.BED_GRAY_WOOD_BIRCH.get());
                        pOutput.accept(ModBlocks.BED_WHITE_WOOD_OAK.get());
                        pOutput.accept(ModBlocks.BED_WHITE_WOOD_BIRCH.get());
                        pOutput.accept(ModBlocks.WARDROBE_MODERN_WOOD_OAK_LEFT.get());
                        pOutput.accept(ModBlocks.WARDROBE_MODERN_WOOD_OAK_RIGHT.get());
                        pOutput.accept(ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_LEFT.get());
                        pOutput.accept(ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_RIGHT.get());
                        pOutput.accept(ModBlocks.PICTURE_FRAME.get());
                        pOutput.accept(ModBlocks.TRASH_CAN_BLACK.get());
                        pOutput.accept(ModBlocks.TRASH_CAN_WHITE.get());
                        pOutput.accept(ModBlocks.SOFA_GRAY.get());
                        pOutput.accept(ModBlocks.SOFA_WHITE.get());
                        pOutput.accept(ModBlocks.FLOOR_LAMP.get());
                        pOutput.accept(ModBlocks.FLOOR_LAMP_B.get());
                        pOutput.accept(ModBlocks.MONITOR.get());
                        pOutput.accept(ModBlocks.MONITOR_DUAL.get());
                        pOutput.accept(ModBlocks.MONITOR_GAMING_MINIMALIST.get());
                        pOutput.accept(ModBlocks.KEYBOARD_MECHANICAL_BLACK.get());
                        pOutput.accept(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_OAK.get());
                        pOutput.accept(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_BIRCH.get());
                        pOutput.accept(ModBlocks.MOUSE_GAMING_BLACK.get());
                        pOutput.accept(ModBlocks.PC_GAMING.get());
                        pOutput.accept(ModBlocks.LAPTOP.get());
                        pOutput.accept(ModBlocks.TV_OLED.get());
                        pOutput.accept(ModBlocks.GAME_CONSOLE.get());
                        pOutput.accept(ModBlocks.COMPUTER_CASE_GAMING.get());
                        pOutput.accept(ModItems.COMPUTER_FAN_BLADE_WHITE.get());
                        pOutput.accept(ModItems.COMPUTER_RAM_GAMING.get());
                        pOutput.accept(ModBlocks.COMPUTER_POWER_SUPPLY.get());
                        pOutput.accept(ModBlocks.MAINBOARD_GAMING.get());
                        pOutput.accept(ModBlocks.GRAPHICS_CARD_GAMING.get());
                        pOutput.accept(ModBlocks.AIO_COOLER_3_FANS.get());
                        pOutput.accept(ModItems.COMPUTER_CPU.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
