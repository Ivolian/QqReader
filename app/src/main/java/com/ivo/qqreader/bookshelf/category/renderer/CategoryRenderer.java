package com.ivo.qqreader.bookshelf.category.renderer;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.helper.BookCoverHelper;
import com.ivo.qqreader.app.dagger.AppScope;
import com.ivo.qqreader.app.helper.DensityHelper;
import com.ivo.qqreader.app.helper.GlideHelper;
import com.ivo.qqreader.bookshelf.category.response.BookCategoryResponse;

import javax.inject.Inject;

@AppScope
public class CategoryRenderer {

    private final GlideHelper glideHelper;

    private final DensityHelper densityHelper;

    @Inject
    public CategoryRenderer(GlideHelper glideHelper, DensityHelper densityHelper) {
        this.glideHelper = glideHelper;
        this.densityHelper = densityHelper;
    }

    public void render(BaseViewHolder viewHolder, MultiItemEntity item) {
        BookCategoryResponse.Category category = (BookCategoryResponse.Category) item;
        viewHolder.setText(R.id.tvCategoryName, category.getCategoryName());
        viewHolder.setText(R.id.tvBookCount, "共" + category.getBookCount() + "册");

        String[] bids = category.getBids().split(",");
        ImageView ivBook = viewHolder.getView(R.id.ivBookMiddle);
        String bid = bids[0];
        String imgUrl = BookCoverHelper.coverUrl(bid);
        glideHelper.loadImg(imgUrl, ivBook);
        ivBook = viewHolder.getView(R.id.ivBookLeft);
        bid = bids[1];
        imgUrl = BookCoverHelper.coverUrl(bid);
        glideHelper.loadImg(imgUrl, ivBook);
        ivBook = viewHolder.getView(R.id.ivBookRight);
        bid = bids[2];
        imgUrl = BookCoverHelper.coverUrl(bid);
        glideHelper.loadImg(imgUrl, ivBook);
    }

}
