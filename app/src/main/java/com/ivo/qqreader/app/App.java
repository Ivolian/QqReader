package com.ivo.qqreader.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ivo.qqreader.BuildConfig;
import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.recommend.model.DaoMaster;
import com.ivo.qqreader.recommend.model.DaoSession;
import com.orhanobut.logger.Logger;

import org.greenrobot.greendao.database.Database;

import me.yokeyword.fragmentation.Fragmentation;

//http://android.reader.qq.com/v6_3_10/nativepage/book/detail?bid=13713126
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        AppComponentProvider.init(this);
        initARouter();
        initFragmentation();
        String tag = "QqReader";
        Logger.init(tag);
        initDb();
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

    private void initDb() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "QqReader-db");
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();

//        List<Ad> adList = new Gson().fromJson(Delete.de(),
//                new TypeToken<List<Ad>>() {
//                }.getType());
//
//        daoSession.getAdDao().insertOrReplaceInTx(adList);
//        for (Ad ad : adList) {
//            if (ad.extInfo != null)
//                daoSession.getExtInfoDao().insertOrReplace(ad.extInfo);
//        }
//        Logger.e("ss");
    }

}
