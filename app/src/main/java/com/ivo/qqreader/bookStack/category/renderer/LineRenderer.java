package com.ivo.qqreader.bookStack.category.renderer;

import android.content.Context;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppScope;
import com.ivo.qqreader.bookStack.category.response.BookCategoryResponse1;

import javax.inject.Inject;

@AppScope
public class LineRenderer {

    private final Context context;

    @Inject
    public LineRenderer(Context context) {
        this.context = context;
    }

    public void render(BaseViewHolder viewHolder, MultiItemEntity item) {
        BookCategoryResponse1.Line line = (BookCategoryResponse1.Line) item;
        viewHolder.setText(R.id.tvTitle,line.getTitle());
    }

}
