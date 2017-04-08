package com.ivo.qqreader.bookStack.category.renderer;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppScope;
import com.ivo.qqreader.app.helper.GlideHelper;
import com.ivo.qqreader.bookStack.category.response.BookCategoryResponse1;

import javax.inject.Inject;

@AppScope
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
        BookCategoryResponse1.Recmd recmd = (BookCategoryResponse1.Recmd) item;
        viewHolder.setText(R.id.tvIntro,recmd.getIntro());
        viewHolder.setText(R.id.tvTitle,recmd.getTitle());
        glideHelper.loadImg(recmd.getImage(),ivImg);
        ivImg.setBackgroundColor(ContextCompat.getColor(context,bgColor(viewHolder.getLayoutPosition())));
    }

    private int bgColor(int position){
        switch (position){
            case 1:
                return R.color.md_pink_300;
            case 2:
                return R.color.md_blue_300;
            case 3:
                return R.color.md_yellow_300;
            case 4:
                return R.color.md_green_300;
                default:
                  return   0;

        }
    }

}
