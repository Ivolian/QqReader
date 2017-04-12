package com.ivo.qqreader.discover.dagger;

import com.ivo.qqreader.discover.network.InfoService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
class DiscoverModule {

    @Discover
    @Provides
    InfoService provideInfoService(Retrofit retrofit) {
        return retrofit.create(InfoService.class);
    }

}
