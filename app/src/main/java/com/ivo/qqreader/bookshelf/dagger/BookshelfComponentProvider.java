package com.ivo.qqreader.bookshelf.dagger;

import com.ivo.qqreader.app.dagger.AppComponentProvider;

import dagger.internal.Preconditions;

public class BookshelfComponentProvider {

    private BookshelfComponentProvider() {
    }

    private static BookshelfComponent bookshelfComponent;

    public static void init() {
        bookshelfComponent = DaggerBookshelfComponent.builder()
                .appComponent(AppComponentProvider.provide())
                .bookshelfModule(new BookshelfModule())
                .build();
    }

    public static BookshelfComponent provide() {
        Preconditions.checkNotNull(bookshelfComponent);
        return bookshelfComponent;
    }

}
