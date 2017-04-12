package com.ivo.qqreader.app.dagger;

import android.content.Context;

import com.ivo.qqreader.app.helper.DensityHelper;
import com.ivo.qqreader.app.helper.GlideHelper;
import com.ivo.qqreader.app.helper.ToastHelper;
import com.ivo.qqreader.main.BackPressConsumer;
import com.ivo.qqreader.sidebar.SidebarAdapter;
import com.ivo.qqreader.sidebar.SidebarFra;
import com.ivo.qqreader.sidebar.SidebarItemDecoration;
import com.ivo.qqreader.sidebar.header.SidebarHeaderView;
import com.ivo.qqreader.ui.HorseTabLayout;

import dagger.Component;
import retrofit2.Retrofit;

@App
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context provideContext();

    Retrofit provideRetrofit();

    GlideHelper provideGlideHelper();

    ToastHelper provideToastHelper();

    DensityHelper provideDensityHelper();

    // main
    void inject(BackPressConsumer o);

    //
    void inject(SidebarItemDecoration o);

    void inject(SidebarAdapter o);

    void inject(SidebarFra o);

    void inject(SidebarHeaderView o);

    void inject(HorseTabLayout o);


}
