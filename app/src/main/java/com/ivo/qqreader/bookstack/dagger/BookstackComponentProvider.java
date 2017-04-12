package com.ivo.qqreader.bookstack.dagger;

import com.ivo.qqreader.app.dagger.AppComponentProvider;

import dagger.internal.Preconditions;

public class BookstackComponentProvider {

    private BookstackComponentProvider() {
    }

    private static BookstackComponent bookstackComponent;

    public static void init() {
        bookstackComponent = DaggerBookstackComponent.builder()
                .appComponent(AppComponentProvider.provide())
                .bookstackModule(new BookstackModule())
                .build();
    }

    public static BookstackComponent provide() {
        Preconditions.checkNotNull(bookstackComponent);
        return bookstackComponent;
    }

}
