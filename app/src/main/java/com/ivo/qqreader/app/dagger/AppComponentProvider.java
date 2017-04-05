package com.ivo.qqreader.app.dagger;

import android.app.Application;

import dagger.internal.Preconditions;

public final class AppComponentProvider {

    private AppComponentProvider() {
    }

    private static AppComponent appComponent;

    public static void init(Application application) {
        AppModule appModule = new AppModule(application);
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();
    }

    public static AppComponent provide() {
        Preconditions.checkNotNull(appComponent);
        return appComponent;
    }

}
