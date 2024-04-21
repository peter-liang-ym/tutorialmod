package peter.tutorialmod.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import peter.tutorialmod.entity.BulletEntity;
import peter.tutorialmod.entity.ModEntities;

public class GunItem extends Item {
    public GunItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.playSound(SoundEvents.ENTITY_ENDERMAN_DEATH, 1, 1);
        ItemStack itemStack = player.getStackInHand(hand);

        if (!world.isClient) {
            BulletEntity bullet = new BulletEntity(ModEntities.BULLET_ENTITY_ENTITY_TYPE, player.getX(), player.getEyeY(), player.getZ(), world);
            bullet.setVelocity(player, player.getPitch(), player.getYaw(), 0f, 5f, 0f);
            world.spawnEntity(bullet);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

}
