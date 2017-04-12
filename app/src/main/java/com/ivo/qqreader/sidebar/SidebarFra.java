package com.ivo.qqreader.sidebar;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.app.helper.ToastHelper;
import com.ivo.qqreader.base.BaseFra;
import com.ivo.qqreader.sidebar.header.SidebarHeaderView;
import com.ivo.qqreader.sidebar.item.SideItemProvider;
import com.ivo.qqreader.sidebar.item.model.SidebarItem;

import javax.inject.Inject;

import butterknife.BindView;

public class SidebarFra extends BaseFra {

    @Override
    protected int layoutResId() {
        return R.layout.frg_sidebar;
    }

    @Override
    protected void init() {
        AppComponentProvider.provide().inject(this);
        initRecycleView();
    }

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private SidebarAdapter sidebarAdapter;

    @Inject
    Context context;

    private void initRecycleView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new SidebarItemDecoration());
        recyclerView.setAdapter(sidebarAdapter = new SidebarAdapter());
        sidebarAdapter.addHeaderView(new SidebarHeaderView(context));
        sidebarAdapter.setNewData(new SideItemProvider().provide());
        setOnItemClickListener();
    }

    @Inject
    ToastHelper toastHelper;

    private void setOnItemClickListener() {
        sidebarAdapter.setOnItemClickListener((adapter, view, position) -> {
            SidebarItem sidebarItem = (SidebarItem) adapter.getData().get(position);
            toastHelper.notSupport(sidebarItem.getText());
        });
    }

}
