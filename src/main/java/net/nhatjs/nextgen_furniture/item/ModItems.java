package net.nhatjs.nextgen_furniture.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NhatJSNextGenFurnitureMod.MOD_ID);

    public static final RegistryObject<Item> NEXTGEN_FURNITURE_LOGO = ITEMS.register("nextgen_furniture_logo",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COMPUTER_FAN_BLADE_WHITE = ITEMS.register("computer_fan_blade_white",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COMPUTER_RAM_GAMING = ITEMS.register("computer_ram_gaming",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COMPUTER_CPU = ITEMS.register("computer_cpu",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCREWDRIVER = ITEMS.register("screwdriver",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRAWER_WHITE = ITEMS.register("drawer_white",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
