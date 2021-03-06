package com.ivo.qqreader.sidebar.item.model;

public class SidebarItem {

    private final Integer icon;

    private final String text;

    public SidebarItem(int icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public Integer getIcon() {
        return icon;
    }

    public String getText() {
        return text;
    }

}
