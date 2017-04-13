package com.ivo.qqreader.bookstack.category.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.f2prateek.dart.InjectExtra;
import com.ivo.qqreader.Key;
import com.ivo.qqreader.R;
import com.ivo.qqreader.base.SwipeBackAct;
import com.ivo.qqreader.bookshelf.BookAdapter;
import com.ivo.qqreader.bookshelf.BookItemDecoration;
import com.ivo.qqreader.bookshelf.dagger.BookshelfComponentProvider;
import com.ivo.qqreader.bookshelf.model.Book;
import com.ivo.qqreader.bookshelf.model.BookResponse;
import com.ivo.qqreader.bookshelf.network.BookService;
import com.ivo.qqreader.navigate.RoutePath;
import com.jakewharton.rxbinding.view.RxView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Route(path = RoutePath.BOOK_CATEGORY_DETAIL_ACT)
public class BookCategoryDetailAct extends SwipeBackAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_book_category_detail;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        BookshelfComponentProvider.provide().inject(this);
        initViews();
        addListeners();
        loadFirst();
    }

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @InjectExtra(Key.TITLE)
    String title;

    private void initViews() {
        tvTitle.setText(title);
        initRecycleView();
    }

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private BookAdapter bookAdapter;

    @Inject
    Context context;

    @Inject
    BookItemDecoration bookItemDecoration;

    private void initRecycleView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(bookItemDecoration);
        recyclerView.setAdapter(bookAdapter = new BookAdapter());
        bookAdapter.setOnLoadMoreListener(this::loadNext, recyclerView);
    }

    @Inject
    BookService bookService;

    @InjectExtra(Key.ACTION_ID)
    String actionId;

    private int pagestamp = 1;

    public Observable<List<Book>> loadBook() {
        return bookService.getBooks("categoryV3", ",-1,-1,-1,-1,6", actionId, pagestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(BookResponse::getBookList);
    }

    private void loadFirst() {
        pagestamp = 1;
        loadBook().subscribe(books -> {
            bookAdapter.setNewData(books);
            pagestamp++;
        });
    }

    private void loadNext() {
        loadBook().subscribe(books -> {
            bookAdapter.loadMoreComplete();
            bookAdapter.addData(books);
            pagestamp++;
        });
    }

    private void addListeners() {
        RxView.clicks(findViewById(R.id.ivBack))
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> super.onBackPressedSupport());
    }

}
