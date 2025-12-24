package net.nhatjs.nextgen_furniture;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.blockentity.ModBlockEntities;
import net.nhatjs.nextgen_furniture.blockentity.renderer.ConsoleRenderer;
import net.nhatjs.nextgen_furniture.blockentity.renderer.LaptopRenderer;
import net.nhatjs.nextgen_furniture.blockentity.renderer.TrashCanRenderer;

public final class NhatJSNextGenFurnitureModClient {
    public static void init(IEventBus eventBus) {
        eventBus.addListener(NhatJSNextGenFurnitureModClient::onClientSetup);
    }

    @SuppressWarnings({"deprecation", "removal"})
    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHAIR_WHITE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHAIR_WOOD_OAK.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TABLE_2X1_BLACK.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TABLE_2X1_BLACK_ALT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TABLE_2X1_BLACK_ALT_2.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TABLE_2X1_WHITE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TABLE_2X1_WHITE_ALT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TABLE_2X1_WHITE_ALT_2.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TABLE_3X1_BLACK.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TABLE_3X1_WHITE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COFFEE_TABLE_WHITE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TABLE_DINING_WHITE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TABLE_DINING_WOOD_OAK.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TV_STAND_WOOD_OAK.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PICTURE_FRAME.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TRASH_CAN_BLACK.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TRASH_CAN_WHITE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOFA_GRAY.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOFA_WHITE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.FLOOR_LAMP.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LAPTOP.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TV_OLED.get(), RenderType.cutoutMipped());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHAIR_WOOD_BIRCH.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TV_STAND_WOOD_BIRCH.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TABLE_DINING_WOOD_BIRCH.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TABLE_1X1_BLACK.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TABLE_1X1_WHITE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.FLOOR_LAMP_B.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BED_GRAY_WOOD_OAK.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BED_GRAY_WOOD_BIRCH.get(), RenderType.cutoutMipped());;
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BED_WHITE_WOOD_OAK.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BED_WHITE_WOOD_BIRCH.get(), RenderType.cutoutMipped());

            BlockEntityRenderers.register(ModBlockEntities.LAPTOP.get(), LaptopRenderer::new);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MONITOR.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MONITOR_GAMING_MINIMALIST.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MOUSE_GAMING_BLACK.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.KEYBOARD_MECHANICAL_BLACK.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GAME_CONSOLE.get(), RenderType.cutoutMipped());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_OAK.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_BIRCH.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WARDROBE_MODERN_WOOD_OAK_LEFT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_LEFT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WARDROBE_MODERN_WOOD_OAK_RIGHT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_RIGHT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHAIR_2_WHITE_GRAY.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHAIR_2_WHITE_WHITE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHAIR_2_WOOD_OAK_GRAY.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHAIR_2_WOOD_OAK_WHITE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHAIR_2_WOOD_BIRCH_GRAY.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHAIR_2_WOOD_BIRCH_WHITE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PC_GAMING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COMPUTER_CASE_GAMING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COMPUTER_POWER_SUPPLY.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAINBOARD_GAMING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRAPHICS_CARD_GAMING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.AIO_COOLER_3_FANS.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PC_GAMING_ADDED_1.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PC_GAMING_ADDED_2.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PC_GAMING_ADDED_3.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PC_GAMING_ADDED_4.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PC_GAMING_ADDED_5.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PC_GAMING_ADDED_6.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PC_GAMING_ADDED_7.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PC_GAMING_ADDED_8.get(), RenderType.cutoutMipped());

            BlockEntityRenderers.register(ModBlockEntities.CONSOLE.get(), ConsoleRenderer::new);
            BlockEntityRenderers.register(ModBlockEntities.TRASH_CAN.get(), TrashCanRenderer::new);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MONITOR_DUAL.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MONITOR_DUAL_ALT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MONITOR_DUAL_ALT_2.get(), RenderType.cutoutMipped());

            //unused
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LAPTOP_SCREEN_OFF.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LAPTOP_SCREEN_ON.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TRASH_CAN_BLACK_EXTRA.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TRASH_CAN_WHITE_EXTRA.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GAME_CONSOLE_EXTRA.get(), RenderType.cutoutMipped());
        });
    }
}