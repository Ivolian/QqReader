package com.ivo.qqreader.bookstack.category;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ivo.qqreader.app.helper.DensityHelper;
import com.ivo.qqreader.bookstack.dagger.BookstackComponentProvider;

import javax.inject.Inject;

public class BookCategoryItemDecoration extends RecyclerView.ItemDecoration {

    @Inject
    DensityHelper densityHelper;

    BookCategoryItemDecoration() {
        BookstackComponentProvider.provide().inject(this);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildLayoutPosition(view);
        if (position == 1 || position == 3) {
            outRect.set(0, 0, 1, 1);
            return;
        }
        outRect.set(0, 0, 0, 1);
    }

}
