package com.ivo.qqreader.bookshelf.dagger;

import com.ivo.qqreader.bookshelf.network.BookService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
class BookshelfModule {

    @Bookshelf
    @Provides
    BookService provideBookService(Retrofit retrofit) {
        return retrofit.create(BookService.class);
    }

}
