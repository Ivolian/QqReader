package com.ivo.qqreader.bookStack;

import android.support.v4.view.ViewPager;

import com.ivo.qqreader.R;
import com.ivo.qqreader.base.BaseFra;
import com.ivo.qqreader.bookStack.adapter.BookStackPagerAdapter;
import com.ivo.qqreader.bookStack.ui.HorseTabLayout;

import butterknife.BindView;

//http://android.reader.qq.com/v6_3_9/queryOperation?categoryFlag=1
public class BookStackFra extends BaseFra {

    @Override
    protected int layoutResId() {
        return R.layout.frg_book_stack;
    }

    @Override
    protected void init() {
        initViewPager();
    }

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.horseTabLayout)
    HorseTabLayout horseTabLayout;

    private void initViewPager() {
        BookStackPagerAdapter adapter = new BookStackPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        horseTabLayout.setUpViewPager(viewPager);
    }

}
