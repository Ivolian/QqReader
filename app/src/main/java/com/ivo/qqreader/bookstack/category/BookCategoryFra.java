package com.ivo.qqreader.bookstack.category;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.base.BaseFra;
import com.ivo.qqreader.bookstack.category.response.BookCategoryResponse;
import com.ivo.qqreader.bookstack.dagger.BookstackComponentProvider;
import com.ivo.qqreader.bookstack.network.BookCategoryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public abstract class BookCategoryFra extends BaseFra {

    protected abstract int categoryFlag();

    @Override
    protected int layoutResId() {
        return R.layout.frg_book_category;
    }

    @Override
    protected void init() {
        BookstackComponentProvider.provide().inject(this);
        initSwipeRefreshLayout();
        initRecycleView();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        swipeRefreshLayout.setRefreshing(true);
        loadBooks();
    }

    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setColorSchemeColors(colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(this::loadBooks);
    }

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    Context context;

    private BookCategoryAdapter bookCategoryAdapter;

    private void initRecycleView() {
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setAdapter(bookCategoryAdapter = new BookCategoryAdapter(new ArrayList<>()));
        recyclerView.addItemDecoration(new BookCategoryItemDecoration());
        bookCategoryAdapter.setSpanSizeLookup((gridLayoutManager, position) -> Arrays.asList(1, 2, 3, 4).contains(position) ? 1 : 2);
    }

    @Inject
    BookCategoryService bookCategoryService;

    private void loadBooks() {
        bookCategoryService.queryOperation(categoryFlag())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BookCategoryResponse>() {
                    @Override
                    public void onCompleted() {
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        showErrorView();
                    }

                    @Override
                    public void onNext(BookCategoryResponse bookCategoryResponse) {
                        hideErrorView();
                        bookCategoryAdapter.setNewData(transform(bookCategoryResponse));
                    }
                });
    }

    private List<MultiItemEntity> transform(BookCategoryResponse bookCategoryResponse) {
        List<MultiItemEntity> multiItemEntities = new ArrayList<>();
        if (bookCategoryResponse.getCount() != null) {
            multiItemEntities.add(bookCategoryResponse.getCount());
        }
        if (bookCategoryResponse.getRecmd() != null) {
            multiItemEntities.addAll(bookCategoryResponse.getRecmd());
        }
        if (bookCategoryResponse.getBoyCategoryList() != null) {
            multiItemEntities.addAll(bookCategoryResponse.getBoyCategoryList());
        }
        if (bookCategoryResponse.getLine() != null) {
            multiItemEntities.add(bookCategoryResponse.getLine());
        }
        if (bookCategoryResponse.getGirlCategoryList() != null) {
            multiItemEntities.addAll(bookCategoryResponse.getGirlCategoryList());
        }
        if (bookCategoryResponse.getPublishCategoryList() != null) {
            multiItemEntities.addAll(bookCategoryResponse.getPublishCategoryList());
        }
        return multiItemEntities;
    }

    @BindView(R.id.errorView)
    FrameLayout errorView;

    private void showErrorView() {
        errorView.setVisibility(View.VISIBLE);
    }


    private void hideErrorView() {
        errorView.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.tvReload)
    public void reload() {
        swipeRefreshLayout.setRefreshing(true);
        loadBooks();
    }

}
