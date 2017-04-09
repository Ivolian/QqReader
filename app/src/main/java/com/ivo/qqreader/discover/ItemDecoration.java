package com.ivo.qqreader.discover;

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

        outRect.set(0, 0, 0, densityHelper.dip2Px(8));
    }

}
