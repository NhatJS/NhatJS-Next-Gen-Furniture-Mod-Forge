package net.nhatjs.nextgen_furniture.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;
import net.nhatjs.nextgen_furniture.entity.client.ChairBlockEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NhatJSNextGenFurnitureMod.MOD_ID);

    public static final RegistryObject<EntityType<ChairBlockEntity>> CHAIR =
            ENTITY_TYPES.register("chair_entity", () -> EntityType.Builder.of(ChairBlockEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("chair_entity"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
