package com.senexmc.withered_potato.util;

import com.senexmc.withered_potato.item.ModItems;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HuskEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier WITHER_SKELETON_ID = new Identifier("minecraft", "entities/wither_skeleton");

    public static void register() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (WITHER_SKELETON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f)) // Drops 10% of the time
                        .with(ItemEntry.builder(ModItems.WITHERED_POTATO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, target) -> {
            if (target instanceof ZombieEntity zombie) {
                if (zombie.hasStatusEffect(StatusEffects.WITHER)) {
                    zombie.dropStack(new ItemStack(ModItems.WITHERED_POTATO), 1.0F);
                }
            }
            if (target instanceof HuskEntity husk) {
                if (husk.hasStatusEffect(StatusEffects.WITHER)) {
                    husk.dropStack(new ItemStack(ModItems.WITHERED_POTATO), 1.0F);
                }
            }
        });
    }
}
