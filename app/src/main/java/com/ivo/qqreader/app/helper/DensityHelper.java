package com.ivo.qqreader.app.helper;

import android.content.Context;

import javax.inject.Inject;

public class DensityHelper {

    private final Context context;

    @Inject
    public DensityHelper(Context context) {
        this.context = context;
    }

    public int dip2Px(float dip) {
        final float density = context.getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5f);
    }

}
