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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.LAPTOP.get()))
                    .title(Component.translatable("creativetab.next_gen_furniture_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.LAPTOP.get());
                        pOutput.accept(ModBlocks.TABLE_2X1_BLACK.get());
                        pOutput.accept(ModBlocks.TABLE_2X1_WHITE.get());
                        pOutput.accept(ModBlocks.TABLE_3X1_BLACK.get());
                        pOutput.accept(ModBlocks.TABLE_3X1_WHITE.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
