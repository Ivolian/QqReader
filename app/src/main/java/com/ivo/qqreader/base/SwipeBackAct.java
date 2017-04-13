package com.ivo.qqreader.base;

import android.os.Bundle;

import com.jude.swipbackhelper.SwipeBackHelper;

public abstract class SwipeBackAct extends BaseAct {

    protected boolean isMain() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)
                .setSwipeEdgePercent(0.1f)
                .setSwipeRelateEnable(true);
        if (isMain()) {
            SwipeBackHelper.getCurrentPage(this).setSwipeBackEnable(false);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
    }

}
