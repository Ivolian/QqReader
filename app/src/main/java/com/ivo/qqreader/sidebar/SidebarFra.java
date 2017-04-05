package com.ivo.qqreader.sidebar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ivo.qqreader.R;

import me.yokeyword.fragmentation.SupportFragment;

public class SidebarFra extends SupportFragment {

    public static SidebarFra newInstance() {
        return new SidebarFra();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frg_sidebar, container, false);
    }

}
