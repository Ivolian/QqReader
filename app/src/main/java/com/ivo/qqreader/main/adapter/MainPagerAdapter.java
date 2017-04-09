package com.ivo.qqreader.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ivo.qqreader.bookshelf.BookshelfFra;
import com.ivo.qqreader.discover.DiscoverFra;
import com.ivo.qqreader.main.temp.AFra;

public class MainPagerAdapter extends FragmentPagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AFra();
            case 1:
                return new AFra();
            case 2:
                return new BookshelfFra();
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
