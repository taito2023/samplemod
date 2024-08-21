package com.example.samplemod.init;

import com.example.samplemod.ExampleMOD;
import com.example.samplemod.entities.MyCustomMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExampleModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ExampleMOD.MOD_ID);

    public static final RegistryObject<EntityType<MyCustomMob>> MY_CUSTOM_MOB = ENTITY_TYPES.register("my_custom_mob",
            () -> EntityType.Builder.of(MyCustomMob::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.8F)
                    .build("my_custom_mob"));
}
