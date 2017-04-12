package com.ivo.qqreader.discover.info;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ivo.qqreader.R;
import com.ivo.qqreader.discover.dagger.DiscoverComponentProvider;
import com.ivo.qqreader.discover.info.renderer.InfoRenderer;
import com.ivo.qqreader.discover.info.response.InfoResponse;

import javax.inject.Inject;

public class InfoAdapter extends BaseQuickAdapter<InfoResponse.InfosBean.Info, BaseViewHolder> {

     InfoAdapter() {
        super(R.layout.item_info);
        DiscoverComponentProvider.provide().inject(this);
    }

    @Inject
    InfoRenderer infoRenderer;

    @Override
    protected void convert(BaseViewHolder viewHolder, InfoResponse.InfosBean.Info item) {
        infoRenderer.render(viewHolder, item);
    }

}