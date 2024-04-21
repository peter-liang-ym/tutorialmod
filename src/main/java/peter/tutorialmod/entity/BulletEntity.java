package peter.tutorialmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
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

    public BulletEntity(EntityType<? extends ThrownItemEntity> entityType, double d, double e, double f, World world) {
        super(entityType, d, e, f, world);
    }

    public BulletEntity(EntityType<? extends ThrownItemEntity> entityType, LivingEntity livingEntity, World world) {
        super(entityType, livingEntity, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult hit) {
        super.onEntityHit(hit);
        Entity e = hit.getEntity();
        e.damage(this.getDamageSources().thrown(this, this.getOwner()), 20);
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
