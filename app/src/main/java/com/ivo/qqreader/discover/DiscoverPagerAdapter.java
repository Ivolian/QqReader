package com.ivo.qqreader.discover;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Arrays;
import java.util.List;

class DiscoverPagerAdapter extends FragmentPagerAdapter {

    DiscoverPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private final List<String> TITLES = Arrays.asList("最新", "经典");

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LatestFra();
            case 1:
                return new ClassicFra();
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
