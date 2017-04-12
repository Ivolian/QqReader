package com.ivo.qqreader.app.dagger;

import android.app.Application;
import android.content.Context;

import com.ivo.qqreader.bookstack.network.BookCategoryService;
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
    BookCategoryService provideBookService(Retrofit retrofit) {
        return retrofit.create(BookCategoryService.class);
    }

}
