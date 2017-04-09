package com.ivo.qqreader.bookshelf;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Arrays;
import java.util.List;

class BookshelfPagerAdapter extends FragmentPagerAdapter {

    BookshelfPagerAdapter(FragmentManager fm) {
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
