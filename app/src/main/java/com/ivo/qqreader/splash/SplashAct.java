package com.ivo.qqreader.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ivo.qqreader.navigate.RoutePath;

import qiu.niorgai.StatusBarCompat;

public class SplashAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarCompat.translucentStatusBar(this);
        navigateToMain();
    }

    private void navigateToMain() {
        ARouter.getInstance().build(RoutePath.MAIN).navigation();
    }

}
