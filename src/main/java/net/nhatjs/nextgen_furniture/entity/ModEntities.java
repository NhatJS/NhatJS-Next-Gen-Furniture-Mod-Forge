package net.nhatjs.nextgen_furniture.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;
import net.nhatjs.nextgen_furniture.entity.client.ChairBlockEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NhatJSNextGenFurnitureMod.MOD_ID);

    public static final RegistryObject<EntityType<ChairBlockEntity>> CHAIR = register("chair", EntityType.Builder.<ChairBlockEntity>of((type, world) ->
            new ChairBlockEntity(world), MobCategory.MISC).sized(0.5f, 0.7f)
            .setCustomClientFactory((spawnEntity, world) -> new ChairBlockEntity(world)));

    public static final RegistryObject<EntityType<ChairBlockEntity>> SOFA = register("sofa", EntityType.Builder.<ChairBlockEntity>of((type, world) ->
                    new ChairBlockEntity(world), MobCategory.MISC).sized(0.5f, 0.55f)
            .setCustomClientFactory((spawnEntity, world) -> new ChairBlockEntity(world)));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder)
    {
        return REGISTER.register(name, () -> builder.build(name));
    }
}
