package com.ivo.qqreader.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter {
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AFra();
            case 1:
                return new BFra();
            case 2:
                return new AFra();
            case 3:
                return new BFra();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

}
