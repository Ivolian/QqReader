package com.ivo.qqreader.sidebar;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.ivo.qqreader.R;
import com.ivo.qqreader.base.BaseFra;
import com.ivo.qqreader.sidebar.item.SideItemProvider;

import butterknife.BindView;

public class SidebarFra extends BaseFra {

    @Override
    protected int layoutResId() {
        return R.layout.frg_sidebar;
    }

    @Override
    protected void init() {
        initRecycleView();
    }

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private void initRecycleView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        SidebarAdapter sidebarAdapter = new SidebarAdapter();
        View headerView = getActivity().getLayoutInflater().inflate(R.layout.header_sidebar, (ViewGroup) recyclerView.getParent(), false);
        sidebarAdapter.addHeaderView(headerView);
        recyclerView.setAdapter(sidebarAdapter);

        recyclerView.addItemDecoration(new SidebarDecoration());

        SideItemProvider provider = new SideItemProvider();
        sidebarAdapter.setNewData(provider.provide());
    }

}
