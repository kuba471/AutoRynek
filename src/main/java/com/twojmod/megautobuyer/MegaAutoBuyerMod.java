package com.twojmod.megautobuyer;

import com.twojmod.megautobuyer.config.ConfigManager;
import com.twojmod.megautobuyer.data.DataManager;
import com.twojmod.megautobuyer.utils.ModLogger;
import net.fabricmc.api.ModInitializer;

public class MegaAutoBuyerMod implements ModInitializer {
    public static final String MOD_ID = "megautobuyer";

    @Override
    public void onInitialize() {
        ModLogger.info("Initializing MegaAutoBuyer");
        ConfigManager.getInstance().load();
        DataManager.getInstance().load();
    }
}
