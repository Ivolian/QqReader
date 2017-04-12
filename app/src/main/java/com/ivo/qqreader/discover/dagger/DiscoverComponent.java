package com.ivo.qqreader.discover.dagger;

import com.ivo.qqreader.app.dagger.AppComponent;
import com.ivo.qqreader.discover.DiscoverFra;
import com.ivo.qqreader.discover.info.InfoAdapter;
import com.ivo.qqreader.discover.info.InfoFra;
import com.ivo.qqreader.discover.info.InfoItemDecoration;

import dagger.Component;

@Discover
@Component(dependencies = AppComponent.class, modules = {DiscoverModule.class})
public interface DiscoverComponent {

    void  inject(DiscoverFra o);
    void  inject(InfoFra o);
    void  inject(InfoAdapter o);
    void  inject(InfoItemDecoration o);

}
