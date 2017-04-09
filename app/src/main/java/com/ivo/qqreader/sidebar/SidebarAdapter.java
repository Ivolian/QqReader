package com.ivo.qqreader.sidebar;

import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.app.helper.GlideHelper;
import com.ivo.qqreader.sidebar.helper.SidebarHelper;
import com.ivo.qqreader.sidebar.item.model.SidebarItem;

import java.util.Arrays;

import javax.inject.Inject;

public class SidebarAdapter extends BaseQuickAdapter<SidebarItem, BaseViewHolder> {

    SidebarAdapter() {
        super(R.layout.item_sidebar);
        AppComponentProvider.provide().inject(this);
    }

    @Inject
    SidebarHelper sidebarHelper;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
        if (isItemView(viewType)) {
            sidebarHelper.initItemOrHeaderBg(viewHolder.getView(R.id.llItem));
        }
        return viewHolder;
    }

    private boolean isItemView(int viewType) {
        return !Arrays.asList(HEADER_VIEW, FOOTER_VIEW, LOADING_VIEW, EMPTY_VIEW).contains(viewType);
    }

    @Inject
    GlideHelper glideHelper;

    @Override
    protected void convert(BaseViewHolder viewHolder, SidebarItem sidebarItem) {
        viewHolder.setText(R.id.tvText, sidebarItem.getText());
        glideHelper.loadImg(sidebarItem.getIcon(), viewHolder.getView(R.id.ivIcon));
    }

}