package com.ivo.qqreader.sidebar;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.app.helper.GlideHelper;
import com.ivo.qqreader.sidebar.item.model.SidebarItem;

import java.util.Arrays;

import javax.inject.Inject;

public class SidebarAdapter extends BaseQuickAdapter<SidebarItem, BaseViewHolder> {

    public SidebarAdapter() {
        super(R.layout.item_sidebar);
        AppComponentProvider.provide().inject(this);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
        if (isItemView(viewType)) {
            initItemBg(viewHolder.getView(R.id.llItem));
        }
        return viewHolder;
    }

    private void initItemBg(LinearLayout llItem) {
        ColorDrawable unpressed = new ColorDrawable();
        unpressed.setColor(ContextCompat.getColor(mContext, R.color.sideBarItemBg));
        ColorDrawable pressed = new ColorDrawable();
        pressed.setColor(ContextCompat.getColor(mContext, android.R.color.transparent));

        StateListDrawable bg = new StateListDrawable();
        bg.addState(new int[]{android.R.attr.state_pressed}, pressed);
        bg.addState(new int[]{-android.R.attr.state_pressed}, unpressed);

        llItem.setBackground(bg);
        llItem.setClickable(true);
    }

    private boolean isItemView(int viewType) {
        return !Arrays.asList(HEADER_VIEW, FOOTER_VIEW, LOADING_VIEW, EMPTY_VIEW).contains(viewType);
    }

    @Inject
    GlideHelper glideHelper;

    @Override
    protected void convert(BaseViewHolder viewHolder, SidebarItem item) {
        viewHolder.setText(R.id.tvText, item.getText());
        glideHelper.loadImg(item.getIcon(), viewHolder.getView(R.id.ivIcon));
    }

}