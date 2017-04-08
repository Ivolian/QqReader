package com.ivo.qqreader.bookStack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ivo.qqreader.bookStack.category.PublishCategoryFra;
import com.ivo.qqreader.bookStack.category.OriginalCategoryFra;

import java.util.Arrays;
import java.util.List;

class BookStackPagerAdapter extends FragmentPagerAdapter {

    BookStackPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private final List<String> TITLES = Arrays.asList("出版图书", "原创文学");

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PublishCategoryFra();
            case 1:
                return new OriginalCategoryFra();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TITLES.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES.get(position);
    }

}
