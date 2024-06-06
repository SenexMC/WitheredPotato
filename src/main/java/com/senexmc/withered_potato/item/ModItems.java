package com.senexmc.withered_potato.item;

import com.senexmc.withered_potato.WitheredPotato;
import com.senexmc.withered_potato.item.custom.ModFoodComponents;
import com.senexmc.withered_potato.item.custom.WitheredPotatoItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item WITHERED_POTATO = registerItem("withered_potato",
            new WitheredPotatoItem(new Item.Settings().rarity(Rarity.UNCOMMON).food(ModFoodComponents.WITHERED_POTATO)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(WitheredPotato.MOD_ID, name), item);
    }

    public static void register() {
        WitheredPotato.LOGGER.info("Registering Mod Items for " + WitheredPotato.MOD_ID);
    }
}
