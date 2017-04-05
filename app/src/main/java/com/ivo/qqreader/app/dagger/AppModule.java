package com.ivo.qqreader.app.dagger;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    private Context context;

    public AppModule(Application application) {
        context = application.getApplicationContext();
    }

    @Provides
    Context provideContext() {
        return context;
    }

}
