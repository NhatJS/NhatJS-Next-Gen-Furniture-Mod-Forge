package net.nhatjs.nextgen_furniture.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;
import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NhatJSNextGenFurnitureMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.COMPUTER_FAN_BLADE_WHITE.get());
        basicItem(ModItems.COMPUTER_CPU.get());
        basicItem(ModItems.COMPUTER_RAM_GAMING.get());
        basicItem(ModItems.DRAWER_WHITE.get());
        withExistingParent(ModBlocks.LAPTOP.get().asItem().toString(), modLoc("block/laptop"));
        basicItem(ModItems.NEXTGEN_FURNITURE_LOGO.get());
        basicItem(ModItems.SCREWDRIVER.get());
    }
}