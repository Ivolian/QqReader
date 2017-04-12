package com.ivo.qqreader.app.dagger;

import com.ivo.qqreader.bookshelf.BookshelfFra;
import com.ivo.qqreader.bookshelf.category.BookCategoryAdapter;
import com.ivo.qqreader.bookshelf.category.BookCategoryFra;
import com.ivo.qqreader.bookshelf.category.BookCategoryItemDecoration;
import com.ivo.qqreader.discover.DiscoverFra;
import com.ivo.qqreader.discover.info.InfoAdapter;
import com.ivo.qqreader.discover.info.InfoFra;
import com.ivo.qqreader.discover.info.InfoItemDecoration;
import com.ivo.qqreader.main.BackPressConsumer;
import com.ivo.qqreader.sidebar.SidebarAdapter;
import com.ivo.qqreader.sidebar.SidebarFra;
import com.ivo.qqreader.sidebar.SidebarItemDecoration;
import com.ivo.qqreader.sidebar.header.SidebarHeaderView;
import com.ivo.qqreader.ui.HorseTabLayout;

import dagger.Component;

@AppScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    // main
    void inject(BackPressConsumer o);

    //
    void inject(SidebarItemDecoration o);

    void inject(SidebarAdapter o);

    void inject(SidebarFra o);

    void inject(SidebarHeaderView o);

    void inject(HorseTabLayout o);

    void inject(BookCategoryFra o);

    void inject(BookCategoryAdapter o);

    void inject(BookCategoryItemDecoration o);

    void inject(BookshelfFra o);

    void inject(DiscoverFra o);

    void inject(InfoAdapter o);

    void inject(InfoFra o);

    void inject(InfoItemDecoration o);

}
