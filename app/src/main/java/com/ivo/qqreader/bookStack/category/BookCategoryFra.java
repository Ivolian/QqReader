package com.ivo.qqreader.bookStack.category;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.base.BaseFra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

// http://android.reader.qq.com/v6_3_9/queryOperation?categoryFlag=1
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

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                s();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    BookCategoryAdapter bookCategoryAdapter;

    private void initRecycleView() {
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));

        List<MultiItemEntity> list = new ArrayList<>();

        bookCategoryAdapter = new BookCategoryAdapter(list);


        recyclerView.setAdapter(bookCategoryAdapter);
    recyclerView.addItemDecoration(new ItemDecoration());
        bookCategoryAdapter.setSpanSizeLookup((gridLayoutManager, position) -> Arrays.asList(1, 2, 3, 4).contains(position) ? 1 : 2);

        s();
    }

    @Inject
    Retrofit retrofit;

    private void s() {
        BookCategoryService bookCategoryService = retrofit.create(BookCategoryService.class);
        bookCategoryService.queryOperation(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BookCategoryResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BookCategoryResponse bookCategoryService) {
                        List<MultiItemEntity> list = new ArrayList<>();
                        list.add(bookCategoryService.getCount());
                        list.addAll(bookCategoryService.getRecmd());
                        list.addAll(bookCategoryService.getBoyCategoryList());
                        list.add(bookCategoryService.getLine());
                        list.addAll(bookCategoryService.getGirlCategoryList());
                        bookCategoryAdapter.setNewData(list);
                    }
                });
    }

}
