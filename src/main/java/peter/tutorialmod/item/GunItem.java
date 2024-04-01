package peter.tutorialmod.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import peter.tutorialmod.entity.BulletEntity;

public class GunItem extends Item {
    public GunItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.playSound(SoundEvents.ENTITY_ENDERMAN_DEATH, 1, 1);

        if (!world.isClient) {
            BulletEntity bulletEntity = new BulletEntity(world, player);
            bulletEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0f, 5f, 0f);
            world.spawnEntity(bulletEntity);
        }

        return super.use(world, player, hand);
    }

}
