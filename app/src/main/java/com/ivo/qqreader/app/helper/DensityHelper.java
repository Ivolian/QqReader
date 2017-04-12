package com.ivo.qqreader.app.helper;

import android.content.Context;

import com.ivo.qqreader.app.dagger.AppScope;

import javax.inject.Inject;

@AppScope
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
