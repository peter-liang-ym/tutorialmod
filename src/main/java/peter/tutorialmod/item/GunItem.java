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

public class GunItem extends Item {
    public GunItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.playSound(SoundEvents.ENTITY_ENDERMAN_DEATH, 1, 1);

        if (!world.isClient) {
            ArrowEntity arrow = new ArrowEntity(world, player, new ItemStack(Items.ARROW));
            arrow.setVelocity(player, player.getPitch(), player.getYaw(), 0, 8, 0);
            world.spawnEntity(arrow);
        }

        return super.use(world, player, hand);
    }

}
