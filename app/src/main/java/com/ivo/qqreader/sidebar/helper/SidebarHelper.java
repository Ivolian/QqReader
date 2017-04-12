package com.ivo.qqreader.sidebar.helper;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;

import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.App;

import javax.inject.Inject;

@App
public class SidebarHelper {

    private final Context context;

    @Inject
    SidebarHelper(Context context) {
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
