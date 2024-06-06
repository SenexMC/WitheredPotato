package com.senexmc.withered_potato;

import com.senexmc.withered_potato.item.ModItemGroup;
import com.senexmc.withered_potato.item.ModItems;
import com.senexmc.withered_potato.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WitheredPotato implements ModInitializer {

	public static final String MOD_ID ="withered_potato";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.register();
		ModItems.register();
		ModLootTableModifiers.register();
	}
}