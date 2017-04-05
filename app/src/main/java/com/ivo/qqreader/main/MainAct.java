package com.ivo.qqreader.main;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ivo.qqreader.R;
import com.ivo.qqreader.main.watcher.BackPressWatcher;
import com.ivo.qqreader.navigate.RoutePath;
import com.ivo.qqreader.sidebar.SidebarFra;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;
import qiu.niorgai.StatusBarCompat;

@Route(path = RoutePath.MAIN)
public class MainAct extends SupportActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        StatusBarCompat.translucentStatusBar(this);
        ButterKnife.bind(this);
        addBackPressWatcher();
        addSidebar();
    }

    private void addSidebar() {
        loadRootFragment(R.id.sidebar_container, SidebarFra.newInstance());
    }

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    private BackPressWatcher backPressWatcher;

    private void addBackPressWatcher() {
        backPressWatcher = new BackPressWatcher(drawerLayout);
    }


    @Override
    public void onBackPressedSupport() {
        if (!backPressWatcher.onBackPressed()) {
            super.onBackPressedSupport();
        }
    }



}
