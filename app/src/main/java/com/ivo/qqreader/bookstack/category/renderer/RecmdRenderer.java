package com.ivo.qqreader.bookstack.category.renderer;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.helper.GlideHelper;
import com.ivo.qqreader.bookstack.category.response.BookCategoryResponse;
import com.ivo.qqreader.bookstack.dagger.Bookstack;

import javax.inject.Inject;

@Bookstack
public class RecmdRenderer {

    private final Context context;
    private final GlideHelper glideHelper;

    @Inject
    public RecmdRenderer(Context context, GlideHelper glideHelper) {
        this.context = context;
        this.glideHelper = glideHelper;
    }

    public void render(BaseViewHolder viewHolder, MultiItemEntity item) {
        ImageView ivImg = viewHolder.getView(R.id.ivImg);
        BookCategoryResponse.Recmd recmd = (BookCategoryResponse.Recmd) item;
        viewHolder.setText(R.id.tvIntro, recmd.getIntro());
        viewHolder.setText(R.id.tvTitle, recmd.getTitle());
        ivImg.setBackgroundColor(ContextCompat.getColor(context, imgBgColor(viewHolder.getLayoutPosition())));
        glideHelper.loadImg(recmd.getImage(), ivImg);
    }

    private int imgBgColor(int position) {
        switch (position) {
            case 1:
                return R.color.md_pink_300;
            case 2:
                return R.color.md_blue_300;
            case 3:
                return R.color.md_yellow_300;
            case 4:
                return R.color.md_green_300;
            default:
                return 0;
        }
    }

}
