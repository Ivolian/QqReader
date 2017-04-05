package com.ivo.qqreader.main;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ivo.qqreader.R;
import com.ivo.qqreader.main.watcher.BackPressWatcher;
import com.ivo.qqreader.navigate.RoutePath;

import butterknife.BindView;
import butterknife.ButterKnife;
import qiu.niorgai.StatusBarCompat;

@Route(path = RoutePath.MAIN)
public class MainAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        ButterKnife.bind(this);
        StatusBarCompat.translucentStatusBar(this);
        addBackPressWatcher();
    }

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    private BackPressWatcher backPressWatcher;

    private void addBackPressWatcher(){
        backPressWatcher = new BackPressWatcher(drawerLayout);
    }

    @Override
    public void onBackPressed() {
        if (!backPressWatcher.onBackPressed()) {
            super.onBackPressed();
        }
    }


}
