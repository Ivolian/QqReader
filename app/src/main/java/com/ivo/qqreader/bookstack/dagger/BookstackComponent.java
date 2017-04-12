package com.ivo.qqreader.bookstack.dagger;

import com.ivo.qqreader.app.dagger.AppComponent;
import com.ivo.qqreader.bookstack.BookstackFra;
import com.ivo.qqreader.bookstack.category.BookCategoryAdapter;
import com.ivo.qqreader.bookstack.category.BookCategoryFra;
import com.ivo.qqreader.bookstack.category.BookCategoryItemDecoration;

import dagger.Component;

@Bookstack
@Component(dependencies = AppComponent.class, modules = {BookstackModule.class})
public interface BookstackComponent {

    void  inject(BookstackFra o);
    void  inject(BookCategoryFra o);
    void  inject(BookCategoryAdapter o);
    void  inject(BookCategoryItemDecoration o);

}
