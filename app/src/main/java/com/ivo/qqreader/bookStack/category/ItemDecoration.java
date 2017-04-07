package com.ivo.qqreader.bookStack.category;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.app.helper.DensityHelper;

import javax.inject.Inject;

public class ItemDecoration extends RecyclerView.ItemDecoration {

    @Inject
    DensityHelper densityHelper;

    public ItemDecoration() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildLayoutPosition(view);
        if (position == 1 || position == 3){
            outRect.set(0, 0, 1, 1);
            return;
        }
        outRect.set(0, 0, 0, 1);
    }

}
