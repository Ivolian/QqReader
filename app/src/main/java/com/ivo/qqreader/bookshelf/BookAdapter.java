package com.ivo.qqreader.bookshelf;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ivo.qqreader.R;
import com.ivo.qqreader.bookshelf.dagger.BookshelfComponentProvider;
import com.ivo.qqreader.bookshelf.model.Book;

import javax.inject.Inject;

public class BookAdapter extends BaseQuickAdapter<Book, BaseViewHolder> {

    BookAdapter() {
        super(R.layout.item_book);
        BookshelfComponentProvider.provide().inject(this);
    }

    @Inject
    BookRenderer bookRenderer;

    @Override
    protected void convert(BaseViewHolder viewHolder, Book item) {
        bookRenderer.render(viewHolder, item);
    }

}