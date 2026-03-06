package com.twojmod.megautobuyer.data;

public class Statistics {
    public int totalPurchases = 0;
    public long totalSpent = 0;

    public void registerPurchase(int price) {
        totalPurchases++;
        totalSpent += price;
    }
}
