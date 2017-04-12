package com.ivo.qqreader.bookstack;

import android.support.v4.view.ViewPager;

import com.ivo.qqreader.R;
import com.ivo.qqreader.app.helper.ToastHelper;
import com.ivo.qqreader.base.BaseFra;
import com.ivo.qqreader.bookstack.dagger.BookstackComponentProvider;
import com.ivo.qqreader.ui.HorseTabLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class BookstackFra extends BaseFra {

    @Override
    protected int layoutResId() {
        return R.layout.frg_bookstack;
    }

    @Override
    protected void init() {
        BookstackComponentProvider.provide().inject(this);
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
        toastHelper.notSupport("查询功能");
    }

}
