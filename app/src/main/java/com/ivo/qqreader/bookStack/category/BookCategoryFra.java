package com.ivo.qqreader.bookStack.category;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.base.BaseFra;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class BookCategoryFra extends BaseFra {

    @Override
    protected int layoutResId() {
        return R.layout.frg_book_category;
    }


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;


    @Inject
    Context context;

    @Override
    protected void init() {
        AppComponentProvider.provide().inject(this);
        initRecycleView();
    }

    private void initRecycleView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        List<MultiItemEntity> list = new ArrayList<>();
        list.add(new Type1());
        list.add(new Type2());
        list.add(new Type1());
        list.add(new Type2());
        list.add(new Type2());
        list.add(new Type2());

        MultipleItemQuickAdapter bookCategoryAdapter = new MultipleItemQuickAdapter(list);


        recyclerView.setAdapter(bookCategoryAdapter);

//        SideItemProvider sideItemProvider = new SideItemProvider();
//        bookCategoryAdapter.(sideItemProvider.provide());
//        setOnItemClickListener(sidebarAdapter);
    }


}
