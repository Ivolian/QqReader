package com.ivo.qqreader.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ivo.qqreader.BuildConfig;
import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.orhanobut.logger.Logger;

import me.yokeyword.fragmentation.Fragmentation;

// http://android.reader.qq.com/v6_3_9/nativepage/infostream/list?periods=2017040808&realdata=1&sex=1&case=A
/// qimei:3910feb22bd16f65
//channel:10004200
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
        initFragmentation();
        AppComponentProvider.init(this);

        Logger.init("QqReader");
    }


    private void initARouter() {
        ARouter.openLog();
        // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.openDebug();
        ARouter.init(this);
    }

    private void initFragmentation() {
        Fragmentation.builder()
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(BuildConfig.DEBUG)
                .install();
    }

}
