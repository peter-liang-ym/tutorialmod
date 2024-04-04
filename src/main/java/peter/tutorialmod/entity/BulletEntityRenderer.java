package peter.tutorialmod.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class BulletEntityRenderer extends FlyingItemEntityRenderer<BulletEntity> {
    public BulletEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }
}
