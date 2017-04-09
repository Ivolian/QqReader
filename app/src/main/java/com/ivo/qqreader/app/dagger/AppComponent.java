package com.ivo.qqreader.app.dagger;

import com.ivo.qqreader.bookStack.BookStackFra;
import com.ivo.qqreader.bookStack.category.BookCategoryAdapter;
import com.ivo.qqreader.bookStack.category.BookCategoryFra;
import com.ivo.qqreader.bookStack.category.ItemDecoration;
import com.ivo.qqreader.discover.DiscoverFra;
import com.ivo.qqreader.discover.info.InfoAdapter;
import com.ivo.qqreader.discover.info.InfoFra;
import com.ivo.qqreader.discover.info.InfoItemDecoration;
import com.ivo.qqreader.main.watcher.BackPressWatcher;
import com.ivo.qqreader.sidebar.SidebarAdapter;
import com.ivo.qqreader.sidebar.SidebarDecoration;
import com.ivo.qqreader.sidebar.SidebarFra;
import com.ivo.qqreader.sidebar.header.SidebarHeaderView;
import com.ivo.qqreader.ui.HorseTabLayout;

import dagger.Component;

@AppScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    void  inject(BackPressWatcher o);
    void  inject(SidebarDecoration o);
    void  inject(SidebarAdapter o);
    void  inject(SidebarFra o);
    void  inject(SidebarHeaderView o);
    void  inject(HorseTabLayout o);
    void  inject(BookCategoryFra o);
    void  inject(BookCategoryAdapter o);
    void  inject(ItemDecoration o);
    void  inject(BookStackFra o);
    void  inject(DiscoverFra o);
    void  inject(InfoAdapter o);
    void  inject(InfoFra o);
    void  inject(InfoItemDecoration o);

}
