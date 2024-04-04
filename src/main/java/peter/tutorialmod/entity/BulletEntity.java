package peter.tutorialmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import peter.tutorialmod.item.ModItems;

public class BulletEntity extends ThrownItemEntity {

    public BulletEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public BulletEntity(World world, LivingEntity owner) {
        super(ModEntities.BULLET_ENTITY_ENTITY_TYPE, owner, world); // null will be changed later
    }

    public BulletEntity(World world, double x, double y, double z) {
        super(ModEntities.BULLET_ENTITY_ENTITY_TYPE, x, y, z, world); // null will be changed later
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 10);
    }

    @Override
    protected ItemStack getItem() {
        return new ItemStack(ModItems.BULLET);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.BULLET;
    }

}
