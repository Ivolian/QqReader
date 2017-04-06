package com.ivo.qqreader.app.dagger;

import com.ivo.qqreader.main.watcher.BackPressWatcher;
import com.ivo.qqreader.sidebar.SidebarAdapter;
import com.ivo.qqreader.sidebar.SidebarDecoration;

import dagger.Component;

@AppScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    void  inject(BackPressWatcher o);
    void  inject(SidebarDecoration o);
    void  inject(SidebarAdapter o);

}
