package com.ivo.qqreader.sidebar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ivo.qqreader.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class SidebarFra extends SupportFragment {
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_sidebar, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private void init() {
        s();
    }

    private void s() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SidebarAdapter sidebarAdapter = new SidebarAdapter();

        View view = getActivity().getLayoutInflater().inflate(R.layout.header_sidebar, (ViewGroup) recyclerView.getParent(), false);

        sidebarAdapter.addHeaderView(view);
        recyclerView.setAdapter(sidebarAdapter);
        recyclerView.addItemDecoration(new SidebarDecoration());

    }

}
