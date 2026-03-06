package com.twojmod.megautobuyer.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twojmod.megautobuyer.MegaAutoBuyerMod;
import com.twojmod.megautobuyer.utils.ModLogger;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ConfigManager {
    private static final ConfigManager INSTANCE = new ConfigManager();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final Path configPath = FabricLoader.getInstance().getConfigDir().resolve(MegaAutoBuyerMod.MOD_ID + ".json");
    private ModConfig config = ModConfig.defaults();

    private ConfigManager() {}

    public static ConfigManager getInstance() {
        return INSTANCE;
    }

    public void load() {
        try {
            if (Files.notExists(configPath)) {
                save();
                return;
            }
            config = GSON.fromJson(Files.readString(configPath), ModConfig.class);
            if (config == null) config = ModConfig.defaults();
        } catch (Exception e) {
            ModLogger.error("Failed to load config", e);
            config = ModConfig.defaults();
        }
    }

    public void save() {
        try {
            Files.createDirectories(configPath.getParent());
            Files.writeString(configPath, GSON.toJson(config));
        } catch (IOException e) {
            ModLogger.error("Failed to save config", e);
        }
    }

    public ModConfig getConfig() {
        return config;
    }
}
