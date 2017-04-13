package com.ivo.qqreader.bookshelf.dagger;

import com.ivo.qqreader.app.dagger.AppComponent;
import com.ivo.qqreader.bookshelf.BookAdapter;
import com.ivo.qqreader.bookshelf.BookListScrollWatcher;
import com.ivo.qqreader.bookshelf.BookRenderer;
import com.ivo.qqreader.bookshelf.BookshelfFra;
import com.ivo.qqreader.bookshelf.header.BookHeaderView;
import com.ivo.qqreader.bookstack.category.detail.BookCategoryDetailAct;

import dagger.Component;

@Bookshelf
@Component(dependencies = AppComponent.class, modules = {BookshelfModule.class})
public interface BookshelfComponent {

    void inject(BookshelfFra o);

    void inject(BookAdapter o);

    void inject(BookHeaderView o);

    void inject(BookRenderer o);

    void inject(BookListScrollWatcher o);

    void inject(BookCategoryDetailAct o);

}
