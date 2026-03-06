package com.twojmod.megautobuyer.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WatchedItem {
    private String itemId;
    private int maxPrice;
    private List<String> requiredLore = new ArrayList<>();
    private Map<String, Integer> requiredEnchantments = new TreeMap<>();
    private boolean enabled = true;
    private int priority = 0;

    public WatchedItem() {}

    public WatchedItem(String itemId, int maxPrice) {
        this.itemId = itemId;
        this.maxPrice = maxPrice;
    }

    public String getItemId() { return itemId; }
    public int getMaxPrice() { return maxPrice; }
    public List<String> getRequiredLore() { return requiredLore; }
    public Map<String, Integer> getRequiredEnchantments() { return requiredEnchantments; }
    public boolean isEnabled() { return enabled; }
    public int getPriority() { return priority; }
}
