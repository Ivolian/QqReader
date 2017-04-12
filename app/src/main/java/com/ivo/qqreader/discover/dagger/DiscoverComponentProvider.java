package com.ivo.qqreader.discover.dagger;

import com.ivo.qqreader.app.dagger.AppComponentProvider;

import dagger.internal.Preconditions;

public class DiscoverComponentProvider {

    private DiscoverComponentProvider() {
    }

    private static DiscoverComponent discoverComponent;

    public static void init() {
        discoverComponent = DaggerDiscoverComponent.builder()
                .appComponent(AppComponentProvider.provide())
                .discoverModule(new DiscoverModule())
                .build();
    }

    public static DiscoverComponent provide() {
        Preconditions.checkNotNull(discoverComponent);
        return discoverComponent;
    }

}
