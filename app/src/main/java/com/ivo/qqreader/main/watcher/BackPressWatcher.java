package com.ivo.qqreader.main.watcher;

import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;

import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.app.helper.ToastHelper;

import javax.inject.Inject;

public class BackPressWatcher {

    private final DrawerLayout drawerLayout;

    public BackPressWatcher(DrawerLayout drawerLayout) {
        this.drawerLayout = drawerLayout;
        AppComponentProvider.provide().inject(this);
    }

    public boolean onBackPressed() {
        return closeDrawer() || showExitPrompt();
    }

    private boolean closeDrawer() {
        int drawerGravity = Gravity.START;
        if (drawerLayout.isDrawerOpen(drawerGravity)) {
            drawerLayout.closeDrawer(drawerGravity);
            return true;
        }
        return false;
    }

    private long lastTime = 0;

    @Inject
    ToastHelper toastHelper;

    private boolean showExitPrompt() {
        final long interval = 2000;
        String msg = "再按一次退出";
        if ((System.currentTimeMillis() - lastTime) > interval) {
            toastHelper.error(msg);
            lastTime = System.currentTimeMillis();
            return true;
        }
        return false;
    }

}
