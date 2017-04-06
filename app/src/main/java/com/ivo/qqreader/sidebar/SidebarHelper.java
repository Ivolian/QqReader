package com.ivo.qqreader.sidebar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;

import com.ivo.qqreader.R;

import javax.inject.Inject;


public class SidebarHelper {

    private final Context context;

    @Inject
    public SidebarHelper(Context context) {
        this.context = context;
    }

    public void initItemOrHeaderBg(ViewGroup viewGroup) {
        ColorDrawable unpressed = new ColorDrawable();
        unpressed.setColor(ContextCompat.getColor(context, R.color.sideBarItemBg));
        ColorDrawable pressed = new ColorDrawable();
        pressed.setColor(ContextCompat.getColor(context, android.R.color.transparent));

        StateListDrawable bg = new StateListDrawable();
        bg.addState(new int[]{android.R.attr.state_pressed}, pressed);
        bg.addState(new int[]{-android.R.attr.state_pressed}, unpressed);

        viewGroup.setBackground(bg);
        viewGroup.setClickable(true);
    }

}