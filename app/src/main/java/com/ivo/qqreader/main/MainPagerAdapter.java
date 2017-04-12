package com.ivo.qqreader.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ivo.qqreader.bookshelf.BookshelfFra;
import com.ivo.qqreader.bookstack.BookstackFra;
import com.ivo.qqreader.discover.DiscoverFra;

class MainPagerAdapter extends FragmentPagerAdapter {

    MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BookshelfFra();
            case 1:
            case 2:
                return new BookstackFra();
            case 3:
                return new DiscoverFra();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

}
