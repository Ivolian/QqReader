package com.ivo.qqreader.main.back;

import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;

public class DrawerLayoutWatcher {

    private DrawerLayout drawerLayout;

    public DrawerLayoutWatcher(DrawerLayout drawerLayout) {
        this.drawerLayout = drawerLayout;
    }

    public boolean onBackPressed() {
        int drawerGravity = Gravity.START;
        if (drawerLayout.isDrawerOpen(drawerGravity)) {
            drawerLayout.closeDrawer(drawerGravity);
            return true;
        }
        return false;
    }

}
