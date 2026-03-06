package com.twojmod.megautobuyer.handlers;

import com.twojmod.megautobuyer.MegaAutoBuyerClient;
import com.twojmod.megautobuyer.gui.screens.AutoBuyerScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public final class KeyBindHandler {
    private KeyBindHandler() {}

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (MegaAutoBuyerClient.OPEN_GUI.wasPressed()) {
                MinecraftClient.getInstance().setScreen(new AutoBuyerScreen());
            }
        });
    }
}
