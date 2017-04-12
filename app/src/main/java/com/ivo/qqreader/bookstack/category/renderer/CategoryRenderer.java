package com.ivo.qqreader.bookstack.category.renderer;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.helper.BookCoverHelper;
import com.ivo.qqreader.app.helper.GlideHelper;
import com.ivo.qqreader.bookstack.category.response.BookCategoryResponse;
import com.ivo.qqreader.bookstack.dagger.Bookstack;

import javax.inject.Inject;

@Bookstack
public class CategoryRenderer {

    private final GlideHelper glideHelper;

    @Inject
    public CategoryRenderer(GlideHelper glideHelper) {
        this.glideHelper = glideHelper;
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
