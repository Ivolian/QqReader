package com.ivo.qqreader.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
    }

    private void initARouter() {
        ARouter.openLog();
        // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.openDebug();
        ARouter.init(this);
    }

}
