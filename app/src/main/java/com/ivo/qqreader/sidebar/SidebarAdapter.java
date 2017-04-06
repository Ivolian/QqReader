package com.ivo.qqreader.sidebar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ivo.qqreader.R;

public class SidebarAdapter extends BaseQuickAdapter<SidebarItem, BaseViewHolder> {

    public SidebarAdapter() {
        super(R.layout.item_sidebar, SideItemProvider.provide());
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, SidebarItem item) {
//        viewHolder.setText(R.id.tweetName, item.getUserName())
//                .setText(R.id.tweetText, item.getText())
//                .setText(R.id.tweetDate, item.getCreatedAt())
//                .setVisible(R.id.tweetRT, item.isRetweet())
//                .linkify(R.id.tweetText);
//                 Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
    }

}