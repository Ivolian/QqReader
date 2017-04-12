package com.ivo.qqreader.app.dagger;

import android.app.Application;
import android.content.Context;

import com.ivo.qqreader.app.BookService;
import com.ivo.qqreader.app.InfoService;
import com.ivo.qqreader.app.network.RetrofitProvider;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
class AppModule {

    private final Context context;

    AppModule(Application application) {
        context = application.getApplicationContext();
    }

    @App
    @Provides
    Context provideContext() {
        return context;
    }

    @App
    @Provides
    Retrofit provideRetrofit(RetrofitProvider retrofitProvider) {
        return retrofitProvider.provide();
    }

    @App
    @Provides
    BookService provideBookService(Retrofit retrofit) {
        return retrofit.create(BookService.class);
    }

    @App
    @Provides
    InfoService provideInfoService(Retrofit retrofit) {
        return retrofit.create(InfoService.class);
    }

}
