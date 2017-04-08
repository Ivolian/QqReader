package com.ivo.qqreader.bookStack.category;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.BookService;
import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.base.BaseFra;
import com.ivo.qqreader.bookStack.category.response.BookCategoryResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
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
        AppComponentProvider.provide().inject(this);
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

    BookCategoryAdapter bookCategoryAdapter;

    private void initRecycleView() {
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setAdapter(bookCategoryAdapter = new BookCategoryAdapter(new ArrayList<>()));
        recyclerView.addItemDecoration(new ItemDecoration());
        bookCategoryAdapter.setSpanSizeLookup((gridLayoutManager, position) -> Arrays.asList(1, 2, 3, 4).contains(position) ? 1 : 2);
    }

    @Inject
    BookService bookService;

    private void loadBooks() {
        bookService.queryOperation(categoryFlag())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BookCategoryResponse>() {
                    @Override
                    public void onCompleted() {
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(BookCategoryResponse categoryResponse) {
                        List<MultiItemEntity> list = new ArrayList<>();
                        if (categoryResponse.getCount() != null) {
                            list.add(categoryResponse.getCount());
                        }
                        if (categoryResponse.getRecmd() != null) {
                            list.addAll(categoryResponse.getRecmd());
                        }

                        if (categoryResponse.getBoyCategoryList() != null) {
                            list.addAll(categoryResponse.getBoyCategoryList());
                        }
                        if (categoryResponse.getLine() != null) {
                            list.add(categoryResponse.getLine());
                        }
                        if (categoryResponse.getGirlCategoryList() != null) {
                            list.addAll(categoryResponse.getGirlCategoryList());
                        }
                        if (categoryResponse.getPublishCategoryList() != null) {
                            list.addAll(categoryResponse.getPublishCategoryList());
                        }
                        bookCategoryAdapter.setNewData(list);
                    }
                });
    }


}
