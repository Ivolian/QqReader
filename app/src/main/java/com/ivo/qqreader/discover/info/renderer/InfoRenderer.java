package com.ivo.qqreader.discover.info.renderer;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.helper.GlideHelper;
import com.ivo.qqreader.discover.dagger.Discover;
import com.ivo.qqreader.discover.info.response.InfoResponse;

import javax.inject.Inject;

@Discover
public class InfoRenderer {

    private final GlideHelper glideHelper;

    @Inject
    public InfoRenderer(GlideHelper glideHelper) {
        this.glideHelper = glideHelper;
    }

    public void render(BaseViewHolder viewHolder, InfoResponse.InfosBean.Info info) {
        viewHolder.setText(R.id.tvTitle, info.getTitle());
        viewHolder.setText(R.id.tvDesc, info.getDesc());
        ImageView ivPic = viewHolder.getView(R.id.ivPic);
        String picUrl = info.getPics().get(0).getUrl();
        glideHelper.loadImg(picUrl, ivPic);
    }

}
