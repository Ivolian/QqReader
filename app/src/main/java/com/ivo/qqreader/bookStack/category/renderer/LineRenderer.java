package com.ivo.qqreader.bookStack.category.renderer;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppScope;
import com.ivo.qqreader.bookStack.category.response.BookCategoryResponse;

import javax.inject.Inject;

@AppScope
public class LineRenderer {

    @Inject
    public LineRenderer() {
    }

    public void render(BaseViewHolder viewHolder, MultiItemEntity item) {
        BookCategoryResponse.Line line = (BookCategoryResponse.Line) item;
        viewHolder.setText(R.id.tvTitle, line.getTitle());
    }

}
