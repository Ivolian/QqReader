package com.ivo.qqreader.main;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ivo.qqreader.R;
import com.ivo.qqreader.main.back.DrawerLayoutWatcher;
import com.ivo.qqreader.navigate.RoutePath;

import butterknife.BindView;
import qiu.niorgai.StatusBarCompat;

@Route(path = RoutePath.MAIN)
public class MainAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        StatusBarCompat.translucentStatusBar(this);
        drawerLayoutWatcher = new DrawerLayoutWatcher(drawerLayout);
    }

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    DrawerLayoutWatcher drawerLayoutWatcher;

    @Override
    public void onBackPressed() {
        if (!drawerLayoutWatcher.onBackPressed()) {
            super.onBackPressed();
        }
    }
//        int drawerGravity = Gravity.START;
//        if (drawerLayout.isDrawerOpen(drawerGravity)) {
//            drawerLayout.closeDrawer(drawerGravity);
//        } else {
//            super.onBackPressed();
//        }

}
