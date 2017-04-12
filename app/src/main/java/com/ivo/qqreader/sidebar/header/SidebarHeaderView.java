package com.ivo.qqreader.sidebar.header;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.app.helper.ToastHelper;
import com.ivo.qqreader.sidebar.helper.SidebarHelper;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SidebarHeaderView extends FrameLayout {

    public SidebarHeaderView(@NonNull Context context) {
        this(context, null);
    }

    public SidebarHeaderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SidebarHeaderView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.header_sidebar, this, true);
        ButterKnife.bind(this);
        AppComponentProvider.provide().inject(this);
        sidebarHelper.initItemOrHeaderBg(clHeader);
    }

    @Inject
    SidebarHelper sidebarHelper;

    @Inject
    ToastHelper toastHelper;

    @BindView(R.id.clHeader)
    ConstraintLayout clHeader;

    @OnClick(R.id.clHeader)
    public void headerOnClick() {
        toastHelper.notSupport("登录功能");
    }

}
