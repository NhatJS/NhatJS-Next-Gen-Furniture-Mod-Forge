package net.nhatjs.nextgen_furniture.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;
import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.item.ModItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> output) {
        //wood
        Block planksBirch = Blocks.BIRCH_PLANKS;
        Block planksOak = Blocks.OAK_PLANKS;

        //stone
        Block buttonStone = Blocks.STONE_BUTTON;

        //wool
        Block woolGray = Blocks.GRAY_WOOL;
        Block woolWhite = Blocks.WHITE_WOOL;

        //banner

        //concrete
        Block concreteBlack = Blocks.BLACK_CONCRETE;
        Block concreteWhite = Blocks.WHITE_CONCRETE;

        //terracotta
        Block terracottaCyan = Blocks.CYAN_TERRACOTTA;

        //dye
        Item dyeBlack = Items.BLACK_DYE;
        Item dyeWhite = Items.WHITE_DYE;

        //misc
        Item stick = Items.STICK;
        Item ingotIron = Items.IRON_INGOT;
        Block blockIron = Blocks.IRON_BLOCK;

        //glass pane
        Block glassPaneStainedBlack = Blocks.BLACK_STAINED_GLASS_PANE;

        //electronic
        Item redstone = Items.REDSTONE;
        Block redstoneLamp = Blocks.REDSTONE_LAMP;
        Block redstoneComparator = Blocks.COMPARATOR;
        Block hopper = Blocks.HOPPER;

        //furniture mod
        RegistryObject<Block> table1x1Black = ModBlocks.TABLE_1X1_BLACK;
        RegistryObject<Block> table1x1White = ModBlocks.TABLE_1X1_WHITE;
        RegistryObject<Block> monitorGamingMinimalist = ModBlocks.MONITOR_GAMING_MINIMALIST;
        RegistryObject<Block> keyboardMechanicalBlack = ModBlocks.KEYBOARD_MECHANICAL_BLACK;
        RegistryObject<Block> mouseGamingBlack = ModBlocks.MOUSE_GAMING_BLACK;
        RegistryObject<Item> computerFanBladeWhite = ModItems.COMPUTER_FAN_BLADE_WHITE;
        RegistryObject<Item> drawerWhite = ModItems.DRAWER_WHITE;
        RegistryObject<Block> drawer3KMWoodOakBase = ModBlocks.DRAWER_3_K_M_WOOD_OAK_BASE;
        RegistryObject<Block> drawer3KMWoodBirchBase = ModBlocks.DRAWER_3_K_M_WOOD_BIRCH_BASE;
        RegistryObject<Block> drawer2KMWoodOakBase = ModBlocks.DRAWER_2_K_M_WOOD_OAK_BASE;
        RegistryObject<Block> drawer2KMWoodBirchBase = ModBlocks.DRAWER_2_K_M_WOOD_BIRCH_BASE;
        RegistryObject<Block> table1x1WoodOak = ModBlocks.TABLE_1X1_WOOD_OAK;
        RegistryObject<Block> table1x1WoodBirch = ModBlocks.TABLE_1X1_WOOD_BIRCH;

        //others
        Block bedGray = Blocks.GRAY_BED;
        Block bedWhite = Blocks.WHITE_BED;
        Block noteBlock = Blocks.NOTE_BLOCK;
        Item endCrystal = Items.END_CRYSTAL;
        Block chest = Blocks.CHEST;
        Item painting = Items.PAINTING;
        Item string = Items.STRING;

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.AIO_COOLER_3_FANS.get())
                .pattern("111")
                .pattern("222")
                .pattern("31 ")
                .define('1', concreteBlack)
                .define('2', computerFanBladeWhite.get())
                .define('3', string)
                .unlockedBy(getHasName(planksBirch), has(planksBirch))
                .unlockedBy(getHasName(computerFanBladeWhite.get()), has(computerFanBladeWhite.get()))
                .unlockedBy(getHasName(string), has(string))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.BED_GRAY_WOOD_BIRCH.get())
                .pattern("121")
                .define('1', planksBirch)
                .define('2', bedGray)
                .unlockedBy(getHasName(planksBirch), has(planksBirch))
                .unlockedBy(getHasName(bedGray), has(bedGray))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.BED_GRAY_WOOD_OAK.get())
                .pattern("121")
                .define('1', planksOak)
                .define('2', bedGray)
                .unlockedBy(getHasName(planksOak), has(planksOak))
                .unlockedBy(getHasName(bedGray), has(bedGray))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.BED_WHITE_WOOD_BIRCH.get())
                .pattern("121")
                .define('1', planksBirch)
                .define('2', bedWhite)
                .unlockedBy(getHasName(planksBirch), has(planksBirch))
                .unlockedBy(getHasName(bedWhite), has(bedWhite))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.BED_WHITE_WOOD_OAK.get())
                .pattern("121")
                .define('1', planksOak)
                .define('2', bedWhite)
                .unlockedBy(getHasName(planksOak), has(planksOak))
                .unlockedBy(getHasName(bedWhite), has(bedWhite))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CHAIR_2_WHITE_GRAY.get(), 2)
                .pattern("1  ")
                .pattern("111")
                .pattern("2 2")
                .define('1', woolGray)
                .define('2', concreteWhite)
                .unlockedBy(getHasName(woolGray), has(woolGray))
                .unlockedBy(getHasName(concreteWhite), has(concreteWhite))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CHAIR_2_WHITE_WHITE.get(), 2)
                .pattern("1  ")
                .pattern("111")
                .pattern("2 2")
                .define('1', woolWhite)
                .define('2', concreteWhite)
                .unlockedBy(getHasName(woolWhite), has(woolWhite))
                .unlockedBy(getHasName(concreteWhite), has(concreteWhite))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CHAIR_2_WOOD_BIRCH_GRAY.get(), 2)
                .pattern("1  ")
                .pattern("111")
                .pattern("2 2")
                .define('1', woolGray)
                .define('2', planksBirch)
                .unlockedBy(getHasName(woolGray), has(woolGray))
                .unlockedBy(getHasName(planksBirch), has(planksBirch))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CHAIR_2_WOOD_BIRCH_WHITE.get(), 2)
                .pattern("1  ")
                .pattern("111")
                .pattern("2 2")
                .define('1', woolWhite)
                .define('2', planksBirch)
                .unlockedBy(getHasName(woolWhite), has(woolWhite))
                .unlockedBy(getHasName(planksBirch), has(planksBirch))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CHAIR_2_WOOD_OAK_GRAY.get(), 2)
                .pattern("1  ")
                .pattern("111")
                .pattern("2 2")
                .define('1', woolGray)
                .define('2', planksOak)
                .unlockedBy(getHasName(woolGray), has(woolGray))
                .unlockedBy(getHasName(planksOak), has(planksOak))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CHAIR_2_WOOD_OAK_WHITE.get(), 2)
                .pattern("1  ")
                .pattern("111")
                .pattern("2 2")
                .define('1', woolWhite)
                .define('2', planksOak)
                .unlockedBy(getHasName(woolWhite), has(woolWhite))
                .unlockedBy(getHasName(planksOak), has(planksOak))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CHAIR_WHITE.get(), 2)
                .pattern("2  ")
                .pattern("211")
                .pattern("2 2")
                .define('1', concreteWhite)
                .define('2', stick)
                .unlockedBy(getHasName(concreteWhite), has(concreteWhite))
                .unlockedBy(getHasName(stick), has(stick))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CHAIR_WOOD_BIRCH.get(), 2)
                .pattern("2  ")
                .pattern("211")
                .pattern("2 2")
                .define('1', planksBirch)
                .define('2', stick)
                .unlockedBy(getHasName(planksBirch), has(planksBirch))
                .unlockedBy(getHasName(stick), has(stick))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CHAIR_WOOD_OAK.get(), 2)
                .pattern("2  ")
                .pattern("211")
                .pattern("2 2")
                .define('1', planksOak)
                .define('2', stick)
                .unlockedBy(getHasName(planksOak), has(planksOak))
                .unlockedBy(getHasName(stick), has(stick))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.COFFEE_TABLE_WHITE.get(), 2)
                .pattern("111")
                .define('1', concreteWhite)
                .unlockedBy(getHasName(concreteWhite), has(concreteWhite))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.COMPUTER_CASE_GAMING.get())
                .pattern("143")
                .pattern("123")
                .pattern("113")
                .define('1', concreteBlack)
                .define('2', redstone)
                .define('3', computerFanBladeWhite.get())
                .define('4', buttonStone)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .unlockedBy(getHasName(redstone), has(redstone))
                .unlockedBy(getHasName(computerFanBladeWhite.get()), has(computerFanBladeWhite.get()))
                .unlockedBy(getHasName(buttonStone), has(buttonStone))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.COMPUTER_CPU.get())
                .pattern(" 2 ")
                .pattern("212")
                .pattern(" 2 ")
                .define('1', endCrystal)
                .define('2', ingotIron)
                .unlockedBy(getHasName(endCrystal), has(endCrystal))
                .unlockedBy(getHasName(ingotIron), has(ingotIron))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.COMPUTER_FAN_BLADE_WHITE.get(), 3)
                .pattern("121")
                .pattern("212")
                .pattern("121")
                .define('1', concreteBlack)
                .define('2', ingotIron)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .unlockedBy(getHasName(ingotIron), has(ingotIron))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.COMPUTER_POWER_SUPPLY.get())
                .pattern("111")
                .pattern("432")
                .pattern("151")
                .define('1', concreteBlack)
                .define('2', redstone)
                .define('3', endCrystal)
                .define('4', buttonStone)
                .define('5', redstoneComparator)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .unlockedBy(getHasName(redstone), has(redstone))
                .unlockedBy(getHasName(endCrystal), has(endCrystal))
                .unlockedBy(getHasName(buttonStone), has(buttonStone))
                .unlockedBy(getHasName(redstoneComparator), has(redstoneComparator))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.COMPUTER_RAM_GAMING.get(), 2)
                .pattern("111")
                .pattern("222")
                .define('1', dyeBlack)
                .define('2', ingotIron)
                .unlockedBy(getHasName(dyeBlack), has(dyeBlack))
                .unlockedBy(getHasName(ingotIron), has(ingotIron))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.DRAWER_WHITE.get(), 3)
                .pattern("1 1")
                .pattern("111")
                .define('1', concreteWhite)
                .unlockedBy(getHasName(concreteWhite), has(concreteWhite))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DRAWER_2_K_M_WOOD_BIRCH_BASE.get(), 2)
                .pattern("111")
                .pattern("2 2")
                .pattern("222")
                .define('1', planksBirch)
                .define('2', concreteWhite)
                .unlockedBy(getHasName(planksBirch), has(planksBirch))
                .unlockedBy(getHasName(concreteWhite), has(concreteWhite))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DRAWER_2_K_M_WOOD_BIRCH.get())
                .pattern("1 ")
                .pattern("12")
                .define('1', drawerWhite.get())
                .define('2', drawer2KMWoodBirchBase.get())
                .unlockedBy(getHasName(drawerWhite.get()), has(drawerWhite.get()))
                .unlockedBy(getHasName(drawer2KMWoodBirchBase.get()), has(drawer2KMWoodBirchBase.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DRAWER_2_K_M_WOOD_OAK_BASE.get(), 2)
                .pattern("111")
                .pattern("2 2")
                .pattern("222")
                .define('1', planksOak)
                .define('2', concreteWhite)
                .unlockedBy(getHasName(planksOak), has(planksOak))
                .unlockedBy(getHasName(concreteWhite), has(concreteWhite))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DRAWER_2_K_M_WOOD_OAK.get())
                .pattern("1 ")
                .pattern("12")
                .define('1', drawerWhite.get())
                .define('2', drawer2KMWoodOakBase.get())
                .unlockedBy(getHasName(drawerWhite.get()), has(drawerWhite.get()))
                .unlockedBy(getHasName(drawer2KMWoodOakBase.get()), has(drawer2KMWoodOakBase.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DRAWER_3_K_M_WOOD_BIRCH_BASE.get(), 2)
                .pattern("111")
                .pattern("222")
                .pattern("222")
                .define('1', planksBirch)
                .define('2', concreteWhite)
                .unlockedBy(getHasName(planksBirch), has(planksBirch))
                .unlockedBy(getHasName(concreteWhite), has(concreteWhite))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DRAWER_3_K_M_WOOD_BIRCH.get())
                .pattern("1 ")
                .pattern("12")
                .pattern("1 ")
                .define('1', drawerWhite.get())
                .define('2', drawer3KMWoodBirchBase.get())
                .unlockedBy(getHasName(drawerWhite.get()), has(drawerWhite.get()))
                .unlockedBy(getHasName(drawer3KMWoodBirchBase.get()), has(drawer3KMWoodBirchBase.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DRAWER_3_K_M_WOOD_OAK_BASE.get(), 2)
                .pattern("111")
                .pattern("222")
                .pattern("222")
                .define('1', planksOak)
                .define('2', concreteWhite)
                .unlockedBy(getHasName(planksOak), has(planksOak))
                .unlockedBy(getHasName(concreteWhite), has(concreteWhite))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DRAWER_3_K_M_WOOD_OAK.get())
                .pattern("1 ")
                .pattern("12")
                .pattern("1 ")
                .define('1', drawerWhite.get())
                .define('2', drawer3KMWoodOakBase.get())
                .unlockedBy(getHasName(drawerWhite.get()), has(drawerWhite.get()))
                .unlockedBy(getHasName(drawer3KMWoodOakBase.get()), has(drawer3KMWoodOakBase.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.FLOOR_LAMP.get())
                .pattern(" 2 ")
                .pattern(" 1 ")
                .pattern("3 3")
                .define('1', planksOak)
                .define('2', redstoneLamp)
                .define('3', stick)
                .unlockedBy(getHasName(planksOak), has(planksOak))
                .unlockedBy(getHasName(redstoneLamp), has(redstoneLamp))
                .unlockedBy(getHasName(stick), has(stick))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.FLOOR_LAMP_B.get())
                .pattern(" 2 ")
                .pattern(" 1 ")
                .pattern("3 3")
                .define('1', planksBirch)
                .define('2', redstoneLamp)
                .define('3', stick)
                .unlockedBy(getHasName(planksBirch), has(planksBirch))
                .unlockedBy(getHasName(redstoneLamp), has(redstoneLamp))
                .unlockedBy(getHasName(stick), has(stick))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GAME_CONSOLE.get())
                .pattern("121")
                .pattern("141")
                .pattern("131")
                .define('1', concreteBlack)
                .define('2', redstone)
                .define('3', endCrystal)
                .define('4', buttonStone)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .unlockedBy(getHasName(redstone), has(redstone))
                .unlockedBy(getHasName(endCrystal), has(endCrystal))
                .unlockedBy(getHasName(buttonStone), has(buttonStone))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GRAPHICS_CARD_GAMING.get())
                .pattern("121")
                .pattern("333")
                .pattern("411")
                .define('1', concreteBlack)
                .define('2', endCrystal)
                .define('3', ingotIron)
                .define('4', redstone)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .unlockedBy(getHasName(endCrystal), has(endCrystal))
                .unlockedBy(getHasName(ingotIron), has(ingotIron))
                .unlockedBy(getHasName(redstone), has(redstone))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.KEYBOARD_MECHANICAL_BLACK.get())
                .pattern("222")
                .pattern("313")
                .define('1', concreteBlack)
                .define('2', buttonStone)
                .define('3', dyeWhite)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .unlockedBy(getHasName(buttonStone), has(buttonStone))
                .unlockedBy(getHasName(dyeWhite), has(dyeWhite))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_OAK.get())
                .pattern("222")
                .pattern("313")
                .define('1', concreteBlack)
                .define('2', buttonStone)
                .define('3', planksOak)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .unlockedBy(getHasName(buttonStone), has(buttonStone))
                .unlockedBy(getHasName(planksOak), has(planksOak))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_BIRCH.get())
                .pattern("222")
                .pattern("313")
                .define('1', concreteBlack)
                .define('2', buttonStone)
                .define('3', planksBirch)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .unlockedBy(getHasName(buttonStone), has(buttonStone))
                .unlockedBy(getHasName(planksBirch), has(planksBirch))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.LAPTOP.get())
                .pattern("131")
                .pattern("567")
                .pattern("242")
                .define('1', concreteBlack)
                .define('2', concreteWhite)
                .define('3', glassPaneStainedBlack)
                .define('4', redstone)
                .define('5', noteBlock)
                .define('6', endCrystal)
                .define('7', buttonStone)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .unlockedBy(getHasName(concreteWhite), has(concreteWhite))
                .unlockedBy(getHasName(glassPaneStainedBlack), has(glassPaneStainedBlack))
                .unlockedBy(getHasName(redstone), has(redstone))
                .unlockedBy(getHasName(noteBlock), has(noteBlock))
                .unlockedBy(getHasName(endCrystal), has(endCrystal))
                .unlockedBy(getHasName(buttonStone), has(buttonStone))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.LIGHT_MODERN.get(), 2)
                .pattern(" 1 ")
                .pattern("121")
                .pattern(" 1 ")
                .define('1', ingotIron)
                .define('2', redstoneLamp)
                .unlockedBy(getHasName(ingotIron), has(ingotIron))
                .unlockedBy(getHasName(redstoneLamp), has(redstoneLamp))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MAINBOARD_GAMING.get())
                .pattern("311")
                .pattern("321")
                .pattern("141")
                .define('1', concreteBlack)
                .define('2', endCrystal)
                .define('3', redstone)
                .define('4', hopper)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .unlockedBy(getHasName(endCrystal), has(endCrystal))
                .unlockedBy(getHasName(redstone), has(redstone))
                .unlockedBy(getHasName(hopper), has(hopper))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MONITOR.get())
                .pattern("1 ")
                .pattern("23")
                .define('1', monitorGamingMinimalist.get())
                .define('2', keyboardMechanicalBlack.get())
                .define('3', mouseGamingBlack.get())
                .unlockedBy(getHasName(monitorGamingMinimalist.get()), has(monitorGamingMinimalist.get()))
                .unlockedBy(getHasName(keyboardMechanicalBlack.get()), has(keyboardMechanicalBlack.get()))
                .unlockedBy(getHasName(mouseGamingBlack.get()), has(mouseGamingBlack.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MONITOR_DUAL.get())
                .pattern("11")
                .pattern("23")
                .define('1', monitorGamingMinimalist.get())
                .define('2', keyboardMechanicalBlack.get())
                .define('3', mouseGamingBlack.get())
                .unlockedBy(getHasName(monitorGamingMinimalist.get()), has(monitorGamingMinimalist.get()))
                .unlockedBy(getHasName(keyboardMechanicalBlack.get()), has(keyboardMechanicalBlack.get()))
                .unlockedBy(getHasName(mouseGamingBlack.get()), has(mouseGamingBlack.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MONITOR_GAMING_MINIMALIST.get())
                .pattern("141")
                .pattern("121")
                .pattern(" 3 ")
                .define('1', concreteBlack)
                .define('2', endCrystal)
                .define('3', terracottaCyan)
                .define('4', redstone)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .unlockedBy(getHasName(endCrystal), has(endCrystal))
                .unlockedBy(getHasName(terracottaCyan), has(terracottaCyan))
                .unlockedBy(getHasName(redstone), has(redstone))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MOUSE_GAMING_BLACK.get())
                .pattern(" 1 ")
                .pattern("324")
                .pattern(" 1 ")
                .define('1', concreteBlack)
                .define('2', endCrystal)
                .define('3', buttonStone)
                .define('4', redstone)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .unlockedBy(getHasName(endCrystal), has(endCrystal))
                .unlockedBy(getHasName(buttonStone), has(buttonStone))
                .unlockedBy(getHasName(redstone), has(redstone))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PICTURE_FRAME.get())
                .pattern("121")
                .define('1', planksOak)
                .define('2', painting)
                .unlockedBy(getHasName(planksOak), has(planksOak))
                .unlockedBy(getHasName(painting), has(painting))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.SCREWDRIVER.get())
                .pattern("1  ")
                .pattern(" 12")
                .pattern(" 21")
                .define('1', ingotIron)
                .define('2', dyeBlack)
                .unlockedBy(getHasName(ingotIron), has(ingotIron))
                .unlockedBy(getHasName(dyeBlack), has(dyeBlack))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SOFA_GRAY.get(), 2)
                .pattern("111")
                .pattern("111")
                .define('1', woolGray)
                .unlockedBy(getHasName(woolGray), has(woolGray))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SOFA_WHITE.get(), 2)
                .pattern("111")
                .pattern("111")
                .define('1', woolWhite)
                .unlockedBy(getHasName(woolWhite), has(woolWhite))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_1X1_BLACK.get(), 2)
                .pattern("11")
                .pattern("22")
                .define('1', concreteBlack)
                .define('2', stick)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .unlockedBy(getHasName(stick), has(stick))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_1X1_WHITE.get(), 2)
                .pattern("11")
                .pattern("22")
                .define('1', concreteWhite)
                .define('2', stick)
                .unlockedBy(getHasName(concreteWhite), has(concreteWhite))
                .unlockedBy(getHasName(stick), has(stick))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_1X1_WOOD_BIRCH.get(), 2)
                .pattern("11")
                .pattern("22")
                .define('1', planksBirch)
                .define('2', stick)
                .unlockedBy(getHasName(planksBirch), has(planksBirch))
                .unlockedBy(getHasName(stick), has(stick))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_1X1_WOOD_OAK.get(), 2)
                .pattern("11")
                .pattern("22")
                .define('1', planksOak)
                .define('2', stick)
                .unlockedBy(getHasName(planksOak), has(planksOak))
                .unlockedBy(getHasName(stick), has(stick))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_2X1_BLACK.get())
                .pattern("11")
                .define('1', table1x1Black.get())
                .unlockedBy(getHasName(table1x1Black.get()), has(table1x1Black.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_2X1_WHITE.get())
                .pattern("11")
                .define('1', table1x1White.get())
                .unlockedBy(getHasName(table1x1White.get()), has(table1x1White.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_2X1_WOOD_BIRCH.get())
                .pattern("11")
                .define('1', table1x1WoodBirch.get())
                .unlockedBy(getHasName(table1x1WoodBirch.get()), has(table1x1WoodBirch.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_2X1_WOOD_OAK.get())
                .pattern("11")
                .define('1', table1x1WoodOak.get())
                .unlockedBy(getHasName(table1x1WoodOak.get()), has(table1x1WoodOak.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_DINING_WHITE.get(), 2)
                .pattern("111")
                .pattern("2 2")
                .define('1', concreteWhite)
                .define('2', concreteBlack)
                .unlockedBy(getHasName(concreteWhite), has(concreteWhite))
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_DINING_WOOD_BIRCH.get(), 2)
                .pattern("111")
                .pattern("2 2")
                .define('1', planksBirch)
                .define('2', concreteBlack)
                .unlockedBy(getHasName(planksBirch), has(planksBirch))
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_DINING_WOOD_OAK.get(), 2)
                .pattern("111")
                .pattern("2 2")
                .define('1', planksOak)
                .define('2', concreteBlack)
                .unlockedBy(getHasName(planksOak), has(planksOak))
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TRASH_CAN_BLACK.get(), 2)
                .pattern("1")
                .pattern("1")
                .define('1', concreteBlack)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TRASH_CAN_WHITE.get(), 2)
                .pattern("1")
                .pattern("1")
                .define('1', concreteWhite)
                .unlockedBy(getHasName(concreteWhite), has(concreteWhite))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TV_OLED.get())
                .pattern("111")
                .pattern("121")
                .pattern("131")
                .define('1', concreteBlack)
                .define('2', endCrystal)
                .define('3', redstone)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .unlockedBy(getHasName(endCrystal), has(endCrystal))
                .unlockedBy(getHasName(redstone), has(redstone))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TV_STAND_WOOD_BIRCH.get())
                .pattern("121")
                .pattern("3 3")
                .define('1', planksBirch)
                .define('2', chest)
                .define('3', concreteBlack)
                .unlockedBy(getHasName(planksBirch), has(planksBirch))
                .unlockedBy(getHasName(chest), has(chest))
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TV_STAND_WOOD_OAK.get())
                .pattern("121")
                .pattern("3 3")
                .define('1', planksOak)
                .define('2', chest)
                .define('3', concreteBlack)
                .unlockedBy(getHasName(planksOak), has(planksOak))
                .unlockedBy(getHasName(chest), has(chest))
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_LEFT.get())
                .pattern("111")
                .pattern("123")
                .pattern("113")
                .define('1', planksBirch)
                .define('2', chest)
                .define('3', concreteBlack)
                .unlockedBy(getHasName(planksBirch), has(planksBirch))
                .unlockedBy(getHasName(chest), has(chest))
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WARDROBE_MODERN_WOOD_OAK_LEFT.get())
                .pattern("111")
                .pattern("123")
                .pattern("113")
                .define('1', planksOak)
                .define('2', chest)
                .define('3', concreteBlack)
                .unlockedBy(getHasName(planksOak), has(planksOak))
                .unlockedBy(getHasName(chest), has(chest))
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_RIGHT.get())
                .pattern("111")
                .pattern("321")
                .pattern("311")
                .define('1', planksBirch)
                .define('2', chest)
                .define('3', concreteBlack)
                .unlockedBy(getHasName(planksBirch), has(planksBirch))
                .unlockedBy(getHasName(chest), has(chest))
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WARDROBE_MODERN_WOOD_OAK_RIGHT.get())
                .pattern("111")
                .pattern("321")
                .pattern("311")
                .define('1', planksOak)
                .define('2', chest)
                .define('3', concreteBlack)
                .unlockedBy(getHasName(planksOak), has(planksOak))
                .unlockedBy(getHasName(chest), has(chest))
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WASHING_MACHINE.get())
                .pattern("121")
                .pattern("434")
                .pattern("141")
                .define('1', concreteBlack)
                .define('2', buttonStone)
                .define('3', blockIron)
                .define('4', redstone)
                .unlockedBy(getHasName(concreteBlack), has(concreteBlack))
                .unlockedBy(getHasName(buttonStone), has(buttonStone))
                .unlockedBy(getHasName(blockIron), has(blockIron))
                .unlockedBy(getHasName(redstone), has(redstone))
                .save(output);
    }
}
