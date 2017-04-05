package com.ivo.qqreader.app.dagger;

import com.ivo.qqreader.main.watcher.BackPressWatcher;

import dagger.Component;

@AppScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    void  inject(BackPressWatcher o);

}
