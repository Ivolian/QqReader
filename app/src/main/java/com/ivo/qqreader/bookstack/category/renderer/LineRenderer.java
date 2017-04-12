package com.ivo.qqreader.bookstack.category.renderer;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.bookstack.category.response.BookCategoryResponse;
import com.ivo.qqreader.bookstack.dagger.Bookstack;

import javax.inject.Inject;

@Bookstack
public class LineRenderer {

    @Inject
    public LineRenderer() {
    }

    public void render(BaseViewHolder viewHolder, MultiItemEntity item) {
        BookCategoryResponse.Line line = (BookCategoryResponse.Line) item;
        viewHolder.setText(R.id.tvTitle, line.getTitle());
    }

}
