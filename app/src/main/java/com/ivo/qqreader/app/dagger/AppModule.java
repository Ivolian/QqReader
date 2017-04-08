package com.ivo.qqreader.app.dagger;

import android.app.Application;
import android.content.Context;

import com.ivo.qqreader.app.BookService;
import com.ivo.qqreader.app.RetrofitProvider;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
public class AppModule {

    private final Context context;

    public AppModule(Application application) {
        context = application.getApplicationContext();
    }

    @Provides
    Context provideContext() {
        return context;
    }

    @AppScope
    @Provides
    Retrofit provideRetrofit(RetrofitProvider retrofitProvider) {
        return retrofitProvider.provide();
    }

    @AppScope
    @Provides
    BookService provideBookService(Retrofit retrofit) {
        return retrofit.create(BookService.class);
    }

}
