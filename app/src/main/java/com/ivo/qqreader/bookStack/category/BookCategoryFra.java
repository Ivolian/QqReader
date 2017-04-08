package com.ivo.qqreader.bookStack.category;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.base.BaseFra;
import com.ivo.qqreader.bookStack.category.response.BookCategoryResponse;

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
public abstract class BookCategoryFra extends BaseFra {

    abstract int  categoryFlag();

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

        swipeRefreshLayout.setOnRefreshListener(() -> {
            s();
            swipeRefreshLayout.setRefreshing(false);
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

    private void s(){
        BookCategoryService bookCategoryService = retrofit.create(BookCategoryService.class);
        bookCategoryService.queryOperation(categoryFlag())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BookCategoryResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(BookCategoryResponse categoryResponse) {
                        List<MultiItemEntity> list = new ArrayList<>();
                        if (categoryResponse.getCount()!=null) {
                            list.add(categoryResponse.getCount());
                        }
                        if (categoryResponse.getRecmd()!=null) {
                            list.addAll(categoryResponse.getRecmd());
                        }

                        if (categoryResponse.getBoyCategoryList()!=null) {
                            list.addAll(categoryResponse.getBoyCategoryList());
                        }
                        if (categoryResponse.getLine()!=null) {
                            list.add(categoryResponse.getLine());
                        }
                        if (categoryResponse.getGirlCategoryList()!=null) {
                            list.addAll(categoryResponse.getGirlCategoryList());
                        }
                        if (categoryResponse.getPublishCategoryList()!=null) {
                            list.addAll(categoryResponse.getPublishCategoryList());
                        }
                        bookCategoryAdapter.setNewData(list);
                    }
                });
    }


}
