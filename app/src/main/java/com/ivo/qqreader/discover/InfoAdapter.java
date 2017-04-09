package com.ivo.qqreader.discover;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ivo.qqreader.app.dagger.AppComponentProvider;

import javax.inject.Inject;

public class InfoAdapter extends BaseQuickAdapter<InfoResponse.InfosBean.Info, BaseViewHolder> {

    public InfoAdapter(int layoutResId) {
        super(layoutResId);
        AppComponentProvider.provide().inject(this);
    }

    @Inject
    InfoRenderer infoRenderer;

    @Override
    protected void convert(BaseViewHolder viewHolder, InfoResponse.InfosBean.Info item) {
        infoRenderer.render(viewHolder, item);
    }

}