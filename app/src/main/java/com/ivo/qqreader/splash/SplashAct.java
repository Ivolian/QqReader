package com.ivo.qqreader.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ivo.qqreader.navigate.RoutePath;

import java.util.concurrent.TimeUnit;

import rx.Observable;

public class SplashAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigateToMain();
    }

    private void navigateToMain() {
        final long delaySeconds = 2;
        Observable.just("o")
                .delay(delaySeconds, TimeUnit.SECONDS)
                .subscribe(o -> {
                    ARouter.getInstance().build(RoutePath.MAIN_ACT).navigation();
                    finish();
                });
    }

}
