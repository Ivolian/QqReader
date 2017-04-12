package com.ivo.qqreader.bookshelf;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.helper.BookCoverHelper;
import com.ivo.qqreader.app.helper.GlideHelper;
import com.ivo.qqreader.bookshelf.dagger.Bookshelf;
import com.ivo.qqreader.bookshelf.model.Book;

import javax.inject.Inject;

@Bookshelf
public class BookRenderer {

    private final GlideHelper glideHelper;

    @Inject
     BookRenderer(GlideHelper glideHelper) {
        this.glideHelper = glideHelper;
    }

    void render(BaseViewHolder viewHolder, Book book) {
        renderCover(viewHolder, book);
        viewHolder.setText(R.id.tvTitle, book.getTitle());
        viewHolder.setText(R.id.tvIntro, book.getIntro());
        viewHolder.setText(R.id.tvAuthor, book.getAuthor());
        viewHolder.setText(R.id.tvRecTitle, book.getExt().getRecTitle());
    }

    private void renderCover(BaseViewHolder viewHolder, Book book) {
        ImageView ivCover = viewHolder.getView(R.id.ivCover);
        String coverUrl = BookCoverHelper.coverUrl(book.getBid() + "");
        glideHelper.loadImg(coverUrl, ivCover);
    }

}
