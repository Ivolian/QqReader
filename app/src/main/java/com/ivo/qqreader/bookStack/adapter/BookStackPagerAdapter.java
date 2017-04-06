package com.ivo.qqreader.bookStack.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ivo.qqreader.main.temp.AFra;
import com.ivo.qqreader.main.temp.BFra;

public class BookStackPagerAdapter extends FragmentPagerAdapter {

    public BookStackPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AFra();
            case 1:
                return new BFra();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

}
