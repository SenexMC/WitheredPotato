package com.senexmc.withered_potato.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class WitheredPotatoItem extends Item {
    public WitheredPotatoItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient()) {
            Random random = new Random();
            if (random.nextFloat() < 0.20) {
                // 20% chance to summon the wither
                WitherEntity wither = new WitherEntity(EntityType.WITHER, world);
                wither.refreshPositionAndAngles(user.getX(), user.getY(), user.getZ(), 0, 0);
                world.spawnEntity(wither);
            }

        }
        return super.finishUsing(stack, world, user);
    }
}
