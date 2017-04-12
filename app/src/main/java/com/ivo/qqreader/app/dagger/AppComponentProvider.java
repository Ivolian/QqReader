package com.ivo.qqreader.app.dagger;

import android.app.Application;

import com.ivo.qqreader.bookstack.dagger.BookstackComponentProvider;
import com.ivo.qqreader.discover.dagger.DiscoverComponentProvider;

import dagger.internal.Preconditions;

public class AppComponentProvider {

    private AppComponentProvider() {
    }

    private static AppComponent appComponent;

    public static void init(Application application) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();

        // other
        BookstackComponentProvider.init();
        DiscoverComponentProvider.init();
    }

    public static AppComponent provide() {
        Preconditions.checkNotNull(appComponent);
        return appComponent;
    }

}
