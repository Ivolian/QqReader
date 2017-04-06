package com.ivo.qqreader.app.helper;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

public class GlideHelper {

    private final Context context;

    @Inject
    public GlideHelper(Context context) {
        this.context = context;
    }

    public void loadImg(@DrawableRes int drawableRes, ImageView target) {
        Glide.with(context).load(drawableRes).crossFade().into(target);
    }

}
