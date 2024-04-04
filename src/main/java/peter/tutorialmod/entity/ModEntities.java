package peter.tutorialmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import peter.tutorialmod.TutorialMod;

public class ModEntities {

    public static final EntityType<BulletEntity> BULLET_ENTITY_ENTITY_TYPE =
            register("bullet", SpawnGroup.MISC, EntityDimensions.fixed(
                    0.5f,0.5f), (BulletEntity::new));

    public static <T extends Entity> EntityType<T> register(String name, SpawnGroup category, EntityDimensions dimensions, EntityType.EntityFactory<T> factory) {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(TutorialMod.MOD_ID, name),
                FabricEntityTypeBuilder.create(category, factory).dimensions(dimensions).trackRangeBlocks(100).trackedUpdateRate(10).build());
    }
}
