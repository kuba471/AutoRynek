package com.twojmod.megautobuyer;

import com.twojmod.megautobuyer.gui.screens.AutoBuyerScreen;
import com.twojmod.megautobuyer.handlers.KeyBindHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class MegaAutoBuyerClient implements ClientModInitializer {
    public static KeyBinding OPEN_GUI;

    @Override
    public void onInitializeClient() {
        OPEN_GUI = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.megautobuyer.open_gui",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                "category.megautobuyer"
        ));

        KeyBindHandler.register();
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(
                literal("autobuyer").then(literal("gui").executes(ctx -> {
                    MinecraftClient.getInstance().setScreen(new AutoBuyerScreen());
                    return 1;
                }))));
    }
}
