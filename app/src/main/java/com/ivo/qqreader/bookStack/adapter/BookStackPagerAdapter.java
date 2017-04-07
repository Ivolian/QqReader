package com.ivo.qqreader.bookStack.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ivo.qqreader.bookStack.category.BookCategoryFra;

public class BookStackPagerAdapter extends FragmentPagerAdapter {

    public BookStackPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BookCategoryFra();
            case 1:
                return new BookCategoryFra();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return position == 0 ? "出版图书" : "原创文学";
    }

}
