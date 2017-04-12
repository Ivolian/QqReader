package com.ivo.qqreader.bookshelf.category.renderer;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.App;
import com.ivo.qqreader.bookshelf.category.response.BookCategoryResponse;

import javax.inject.Inject;

@App
public class LineRenderer {

    @Inject
    public LineRenderer() {
    }

    public void render(BaseViewHolder viewHolder, MultiItemEntity item) {
        BookCategoryResponse.Line line = (BookCategoryResponse.Line) item;
        viewHolder.setText(R.id.tvTitle, line.getTitle());
    }

}
