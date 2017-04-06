package com.ivo.qqreader.sidebar;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ivo.qqreader.R;
import com.ivo.qqreader.sidebar.item.SideItemProvider;

import java.util.Arrays;

public class SidebarAdapter extends BaseQuickAdapter<SidebarItem, BaseViewHolder> {

    public SidebarAdapter() {
        super(R.layout.item_sidebar, SideItemProvider.provide());
    }

    private void s(LinearLayout linearLayout){

        ColorDrawable unpressed = new ColorDrawable();
        unpressed.setColor(ContextCompat.getColor(mContext,R.color.sideBarItemBg));


        ColorDrawable pressed = new ColorDrawable();
        pressed.setColor(ContextCompat.getColor(mContext,android.R.color.transparent));


        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressed);
        stateListDrawable.addState(new int[]{-android.R.attr.state_pressed}, unpressed);


        linearLayout.setBackground(stateListDrawable);
        linearLayout.setClickable(true);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        BaseViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);


        if (!Arrays.asList(HEADER_VIEW,FOOTER_VIEW,LOADING_VIEW,EMPTY_VIEW).contains(viewType)) {
            LinearLayout linearLayout = viewHolder.getView(R.id.llRoot);
            s(linearLayout);
        }
        return viewHolder;
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, SidebarItem item) {
        viewHolder.setText(R.id.tvText, item.getText());

        Integer draw = item.getDrawableRes();
        if (draw!=null) {
            Glide.with(mContext).load(item.getDrawableRes()).crossFade().into((ImageView) viewHolder.getView(R.id.ivIcon));
        }else {
//            viewHolder.getView(R.id.ivIcon).setVisibility(View.INVISIBLE);
        }
        }

}