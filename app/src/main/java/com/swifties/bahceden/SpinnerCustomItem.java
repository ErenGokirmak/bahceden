package com.swifties.bahceden;

public class SpinnerCustomItem {

    private String ItemName;
    private int ItemIcon;

    public SpinnerCustomItem(String itemName, int itemIcon) {
        ItemName = itemName;
        ItemIcon = itemIcon;
    }

    public String getItemName() {
        return ItemName;
    }

    public int getItemIcon() {
        return ItemIcon;
    }
}
