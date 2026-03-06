package com.twojmod.megautobuyer.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twojmod.megautobuyer.MegaAutoBuyerMod;
import com.twojmod.megautobuyer.utils.ModLogger;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class DataManager {
    private static final DataManager INSTANCE = new DataManager();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final Path statsPath = FabricLoader.getInstance().getConfigDir().resolve(MegaAutoBuyerMod.MOD_ID + "_stats.json");
    private Statistics statistics = new Statistics();

    public static DataManager getInstance() { return INSTANCE; }

    public void load() {
        try {
            if (Files.exists(statsPath)) {
                statistics = GSON.fromJson(Files.readString(statsPath), Statistics.class);
                if (statistics == null) statistics = new Statistics();
            }
        } catch (Exception e) {
            ModLogger.error("Failed loading stats", e);
            statistics = new Statistics();
        }
    }

    public void save() {
        try {
            Files.createDirectories(statsPath.getParent());
            Files.writeString(statsPath, GSON.toJson(statistics));
        } catch (IOException e) {
            ModLogger.error("Failed saving stats", e);
        }
    }

    public Statistics getStatistics() { return statistics; }
}
