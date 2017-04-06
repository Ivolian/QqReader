package com.ivo.qqreader.sidebar;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.app.helper.DensityHelper;

import java.util.Arrays;

import javax.inject.Inject;

public class SidebarDecoration extends RecyclerView.ItemDecoration {

    @Inject
    DensityHelper densityHelper;

    public SidebarDecoration() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildLayoutPosition(view);
        boolean flag = Arrays.asList(0, 2, 5, state.getItemCount() - 1).contains(position);
        int offset = flag ? densityHelper.dip2Px(15) : densityHelper.dip2Px(3);
        outRect.set(0, 0, 0, offset);
    }

}
