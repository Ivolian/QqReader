package com.ivo.qqreader.bookstack.dagger;

import com.ivo.qqreader.bookstack.network.BookCategoryService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
class BookstackModule {

    @Bookstack
    @Provides
    BookCategoryService provideBookCategoryService(Retrofit retrofit) {
        return retrofit.create(BookCategoryService.class);
    }

}
