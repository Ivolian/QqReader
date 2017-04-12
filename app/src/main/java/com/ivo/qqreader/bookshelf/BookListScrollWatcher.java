package com.ivo.qqreader.bookshelf;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.ivo.qqreader.R;
import com.ivo.qqreader.app.helper.DensityHelper;
import com.ivo.qqreader.bookshelf.dagger.BookshelfComponentProvider;

import javax.inject.Inject;

public class BookListScrollWatcher {

    private final RecyclerView rvBookList;

    private final LinearLayout llTitleBar;

    BookListScrollWatcher(RecyclerView rvBookList, LinearLayout llTitleBar) {
        this.rvBookList = rvBookList;
        this.llTitleBar = llTitleBar;
        BookshelfComponentProvider.provide().inject(this);
    }

    @Inject
    Context context;

    @Inject
    DensityHelper densityHelper;

    private int oldTotalDy = 0;

    void watch() {
        int distance = densityHelper.dip2Px(80);
        rvBookList.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int totalDy = oldTotalDy + dy;
                if (oldTotalDy < distance && totalDy >= distance) {
                    fadeTitleBar(true);
                }
                if (oldTotalDy > distance && totalDy <= distance) {
                    fadeTitleBar(false);
                }
                oldTotalDy = totalDy;
            }
        });
    }

    private void fadeTitleBar(boolean fadeIn) {
        int colorPrimary = ContextCompat.getColor(context, R.color.colorPrimary);
        ValueAnimator valueAnimator = fadeIn ? ValueAnimator.ofInt(0, 255) : ValueAnimator.ofInt(255, 0);
        int fadeDuration = 200;
        valueAnimator.setDuration(fadeDuration);
        valueAnimator.addUpdateListener(animation -> {
            int alpha = (int) animation.getAnimatedValue();
            int color = ColorUtils.setAlphaComponent(colorPrimary, alpha);
            llTitleBar.setBackgroundColor(color);
        });
        valueAnimator.start();
    }

}
