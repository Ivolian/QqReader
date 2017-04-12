package com.ivo.qqreader.discover.info;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ivo.qqreader.app.helper.DensityHelper;
import com.ivo.qqreader.discover.dagger.DiscoverComponentProvider;

import javax.inject.Inject;

public class InfoItemDecoration extends RecyclerView.ItemDecoration {

    @Inject
    DensityHelper densityHelper;

    public InfoItemDecoration() {
        DiscoverComponentProvider.provide().inject(this);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildLayoutPosition(view);
        int offset = densityHelper.dip2Px(position == state.getItemCount() - 1 ? 0 : 8);
        outRect.set(0, 0, 0, offset);
    }

}
