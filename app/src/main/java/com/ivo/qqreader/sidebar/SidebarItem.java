package com.ivo.qqreader.sidebar;

public class SidebarItem {

    private Integer drawableRes;

    private String text;

    public Integer getDrawableRes() {
        return drawableRes;
    }

    public SidebarItem(String text) {
        this.text = text;
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
