package com.ivo.qqreader.discover;

import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.app.helper.ToastHelper;
import com.ivo.qqreader.base.BaseFra;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class DiscoverFra extends BaseFra {

    @Override
    protected int layoutResId() {
        return R.layout.frg_discover;
    }

    @Override
    protected void init() {
        AppComponentProvider.provide().inject(this);
        initViews();
    }

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    SlidingTabLayout tabLayout;

    private void initViews() {
        viewPager.setAdapter(new DiscoverPagerAdapter(getChildFragmentManager()));
        tabLayout.setViewPager(viewPager);
    }

    @Inject
    ToastHelper toastHelper;

    @OnClick(R.id.ivSearch)
    public void searchOnClick() {
        toastHelper.wontDevelop("查询功能");
    }
}
