package com.senexmc.withered_potato.item;

import com.senexmc.withered_potato.WitheredPotato;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup POTATO_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(WitheredPotato.MOD_ID, "potato"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.potato"))
                    .icon(()-> new ItemStack(ModItems.WITHERED_POTATO)).entries((displayContext, entries) -> {
                        entries.add(ModItems.WITHERED_POTATO);
                    }).build());

    public static void register() {

    }
}
