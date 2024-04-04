package peter.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import peter.tutorialmod.entity.BulletEntityRenderer;
import peter.tutorialmod.entity.ModEntities;

public class TutorialModClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.BULLET_ENTITY_ENTITY_TYPE, BulletEntityRenderer::new);
    }
}
