package com.ivo.qqreader.discover.info;

import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ivo.qqreader.Key;
import com.ivo.qqreader.R;
import com.ivo.qqreader.discover.dagger.DiscoverComponentProvider;
import com.ivo.qqreader.discover.info.renderer.InfoRenderer;
import com.ivo.qqreader.discover.info.response.InfoResponse;
import com.ivo.qqreader.navigate.RoutePath;
import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class InfoAdapter extends BaseQuickAdapter<InfoResponse.InfosBean.Info, BaseViewHolder> {

    InfoAdapter() {
        super(R.layout.item_info);
        DiscoverComponentProvider.provide().inject(this);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
        addListener(viewHolder.getConvertView(), viewHolder);
        return viewHolder;
    }

    private void addListener(View itemView, BaseViewHolder viewHolder) {
        RxView.clicks(itemView)
                .throttleFirst(1, TimeUnit.SECONDS)
                .map(aVoid -> getItem(viewHolder.getAdapterPosition()))
                .subscribe((InfoResponse.InfosBean.Info info) -> ARouter.getInstance().build(RoutePath.INFO_DETAIL_ACT)
                        .withString(Key.INFO_TITLE, info.getTitle())
                        .withString(Key.INFO_URL, info.getQurl())
                        .navigation());
    }

    @Inject
    InfoRenderer infoRenderer;

    @Override
    protected void convert(BaseViewHolder viewHolder, InfoResponse.InfosBean.Info item) {
        infoRenderer.render(viewHolder, item);
    }

}