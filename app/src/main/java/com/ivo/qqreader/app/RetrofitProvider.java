package com.ivo.qqreader.app;


import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitProvider {

    @Inject
    RetrofitProvider() {
    }

    public final Retrofit provide() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS);
//            okHttpClientBuilder.addNetworkInterceptor(new StethoInterceptor());
        OkHttpClient okHttpClient = okHttpClientBuilder.build();
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(AppConfig.BASE_REQUEST_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
