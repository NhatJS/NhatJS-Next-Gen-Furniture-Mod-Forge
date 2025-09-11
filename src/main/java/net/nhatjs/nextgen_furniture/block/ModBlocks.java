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

    public static final RegistryObject<Block> CHAIR_WHITE = registerBlock("chair_white", () -> new ChairBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> CHAIR_WOOD_OAK = registerBlock("chair_wood_oak", () -> new ChairBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> TABLE_2X1_BLACK = registerBlock("table_2x1_black", () -> new Table2x1CenterBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> TABLE_2X1_BLACK_ALT = registerBlock("table_2x1_black_alt", () -> new Table2x1LeftBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> TABLE_2X1_BLACK_ALT_2 = registerBlock("table_2x1_black_alt_2", () -> new Table2x1RightBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> TABLE_2X1_WHITE = registerBlock("table_2x1_white", () -> new Table2x1CenterBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> TABLE_2X1_WHITE_ALT = registerBlock("table_2x1_white_alt", () -> new Table2x1LeftBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> TABLE_2X1_WHITE_ALT_2 = registerBlock("table_2x1_white_alt_2", () -> new Table2x1RightBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> TABLE_3X1_BLACK = registerBlock("table_3x1_black", () -> new Table3x1Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> TABLE_3X1_WHITE = registerBlock("table_3x1_white", () -> new Table3x1Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> TABLE_DINING_WHITE = registerBlock("table_dining_white", () -> new DiningTableBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> TABLE_DINING_WOOD_OAK = registerBlock("table_dining_wood_oak", () -> new DiningTableBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> PICTURE_FRAME = registerBlock("picture_frame", () -> new PictureFrameBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0F).noOcclusion()));
    public static final RegistryObject<Block> LAPTOP = registerBlock("laptop", () -> new LaptopBlock(BlockBehaviour.Properties.of()
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
