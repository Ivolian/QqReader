package com.ivo.qqreader.bookshelf;

import android.support.v4.view.ViewPager;

import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.app.helper.ToastHelper;
import com.ivo.qqreader.base.BaseFra;
import com.ivo.qqreader.ui.HorseTabLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class BookshelfFra extends BaseFra {

    @Override
    protected int layoutResId() {
        return R.layout.frg_bookshelf;
    }

    @Override
    protected void init() {
        AppComponentProvider.provide().inject(this);
        initViews();
    }

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.horseTabLayout)
    HorseTabLayout horseTabLayout;

    private void initViews() {
        viewPager.setAdapter(new BookshelfPagerAdapter(getChildFragmentManager()));
        horseTabLayout.setUpViewPager(viewPager);
    }

    @Inject
    ToastHelper toastHelper;

    @OnClick(R.id.ivSearch)
    public void searchOnClick() {
        toastHelper.wontDevelop("查询功能");
    }

}
