package com.twojmod.megautobuyer.gui.screens;

import com.twojmod.megautobuyer.config.ConfigManager;
import com.twojmod.megautobuyer.config.WatchedItem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class AutoBuyerScreen extends Screen {
    public AutoBuyerScreen() {
        super(Text.translatable("screen.megautobuyer.title"));
    }

    @Override
    protected void init() {
        addDrawableChild(ButtonWidget.builder(Text.translatable("screen.megautobuyer.add_demo"), b -> {
            WatchedItem item = new WatchedItem("minecraft:diamond_sword", 1000);
            ConfigManager.getInstance().getConfig().watchedItems().add(item);
            ConfigManager.getInstance().save();
        }).dimensions(this.width / 2 - 75, this.height / 2 - 10, 150, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(textRenderer, title, width / 2, 20, 0xFFFFFF);
        context.drawTextWithShadow(textRenderer,
                Text.translatable("screen.megautobuyer.items", ConfigManager.getInstance().getConfig().watchedItems().size()),
                width / 2 - 75,
                height / 2 - 40,
                0xAAAAAA);
        super.render(context, mouseX, mouseY, delta);
    }
}
