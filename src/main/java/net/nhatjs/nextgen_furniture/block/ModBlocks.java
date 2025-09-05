package net.nhatjs.nextgen_furniture.block;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;
import net.nhatjs.nextgen_furniture.item.ModItems;

import java.util.function.Supplier;

@RegistryContainer
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NhatJSNextGenFurnitureMod.MOD_ID);

    public static final RegistryObject<Block> LAPTOP = registerBlock("laptop", () -> new LaptopBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> TABLE_2X1_BLACK = registerBlock("table_2x1_black", () -> new Table2x1Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> TABLE_2X1_WHITE = registerBlock("table_2x1_white", () -> new Table2x1Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> TABLE_3X1_BLACK = registerBlock("table_3x1_black", () -> new Table3x1Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> TABLE_3X1_WHITE = registerBlock("table_3x1_white", () -> new Table3x1Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
