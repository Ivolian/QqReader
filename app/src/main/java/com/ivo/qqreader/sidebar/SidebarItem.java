package com.ivo.qqreader.sidebar;

public class SidebarItem {

    private int drawableRes;

    private String text;

    public int getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.drawableRes = drawableRes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SidebarItem(int drawableRes, String text) {
        this.drawableRes = drawableRes;
        this.text = text;


    }
}
