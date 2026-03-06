package com.twojmod.megautobuyer.config;

import java.util.ArrayList;
import java.util.List;

public record ModConfig(int version, ScannerSettings scannerSettings, ClickerSettings clickerSettings,
                        List<WatchedItem> watchedItems) {
    public static ModConfig defaults() {
        return new ModConfig(1, new ScannerSettings(1000, "ADAPTIVE"), new ClickerSettings(120, true), new ArrayList<>());
    }

    public record ScannerSettings(int delayMs, String mode) {}
    public record ClickerSettings(int clickDelayMs, boolean humanize) {}
}
