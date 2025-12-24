package net.nhatjs.nextgen_furniture;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.blockentity.ModBlockEntities;
import net.nhatjs.nextgen_furniture.entity.ModEntities;
import net.nhatjs.nextgen_furniture.entity.renderer.ChairRenderer;
import net.nhatjs.nextgen_furniture.item.ModCreativeModTabs;
import net.nhatjs.nextgen_furniture.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NhatJSNextGenFurnitureMod.MOD_ID)
public class NhatJSNextGenFurnitureMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "nextgen_furniture";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public NhatJSNextGenFurnitureMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModEntities.REGISTER.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        NhatJSNextGenFurnitureModClient.init(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener((ModelEvent.RegisterAdditional e) -> {
            e.register(ModelResourceLocation.inventory(NhatJSNextGenFurnitureModClient.LAPTOP_SCREEN));
            e.register(ModelResourceLocation.inventory(NhatJSNextGenFurnitureModClient.LAPTOP_SCREEN_ON));
            e.register(ModelResourceLocation.inventory(NhatJSNextGenFurnitureModClient.GAME_CONSOLE_EXTRA));
            e.register(ModelResourceLocation.inventory(NhatJSNextGenFurnitureModClient.TRASH_CAN_BLACK_EXTRA));
            e.register(ModelResourceLocation.inventory(NhatJSNextGenFurnitureModClient.TRASH_CAN_WHITE_EXTRA));
        });

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.CHAIR.get(), ChairRenderer::new);
            EntityRenderers.register(ModEntities.SOFA.get(), ChairRenderer::new);
        }
    }
}
