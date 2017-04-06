package com.ivo.qqreader.sidebar.item.model;

public class SidebarItem {

    private Integer icon;

    private String text;

    public SidebarItem(int icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
