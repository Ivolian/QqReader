package com.ivo.qqreader.bookshelf;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.ivo.qqreader.R;
import com.ivo.qqreader.base.BaseFra;
import com.ivo.qqreader.bookshelf.dagger.BookshelfComponentProvider;
import com.ivo.qqreader.bookshelf.header.BookHeaderView;
import com.ivo.qqreader.bookshelf.model.Book;
import com.ivo.qqreader.bookshelf.model.BookResponse;
import com.ivo.qqreader.bookshelf.network.BookService;
import com.ivo.qqreader.bus.BusAction;
import com.orhanobut.logger.Logger;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BookshelfFra extends BaseFra {

    @Override
    protected int layoutResId() {
        return R.layout.fra_bookshelf;
    }


    @Override
    protected void init() {
        BookshelfComponentProvider.provide().inject(this);
        initSwipeRefreshLayout();
        initRecycleView();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        swipeRefreshLayout.setRefreshing(true);
        loadFirst();
    }

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setColorSchemeColors(colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(this::loadFirst);
    }

    @Inject
    Context context;

    @Inject
    BookItemDecoration bookItemDecoration;

    private BookAdapter bookAdapter;

    private void initRecycleView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(bookItemDecoration);
        recyclerView.setAdapter(bookAdapter = new BookAdapter());
        bookHeaderView = new BookHeaderView(context);
        bookAdapter.addHeaderView(bookHeaderView);
        bookAdapter.setOnLoadMoreListener(this::loadNext, recyclerView);
        addScrollWatcher();
    }

    private BookHeaderView bookHeaderView;

    @Override
    public void onSupportVisible() {
        bookHeaderView.zoom();
    }

    @Inject
    BookService bookService;

    public Observable<List<Book>> loadBook() {
        return bookService.getBooks("categoryV3", ",-1,-1,-1,-1,6", "20001", pagestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(BookResponse::getBookList);
    }

    private int pagestamp = 1;

    private void loadFirst() {
        pagestamp = 1;
        loadBook().subscribe(new Subscriber<List<Book>>() {
            @Override
            public void onCompleted() {
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {
                swipeRefreshLayout.setRefreshing(false);
                Logger.e(e, "");
//                showErrorView();
            }

            @Override
            public void onNext(List<Book> books) {
//                hideErrorView();
                bookAdapter.setNewData(books);
                pagestamp++;
            }
        });
    }

    private void loadNext() {
        loadBook().subscribe(new Subscriber<List<Book>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
//                showErrorView();
            }

            @Override
            public void onNext(List<Book> books) {
//                hideErrorView();
                bookAdapter.loadMoreComplete();
                bookAdapter.addData(books);
                pagestamp++;
            }
        });
    }

    @OnClick(R.id.ivTitleBarAvator)
    public void avatorOnClick() {
        RxBus.get().post(BusAction.OPEN_DRAWER, new Object());
    }


    @BindView(R.id.llTitleBar)
    LinearLayout llTitleBar;


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    private void addScrollWatcher() {
        BookListScrollWatcher bookListScrollWatcher = new BookListScrollWatcher(recyclerView, llTitleBar);
        bookListScrollWatcher.watch();
    }

    @Subscribe(tags = {@Tag(BusAction.BACK_TO_TOP)})
    public void backToTop(Object o) {
        recyclerView.smoothScrollToPosition(0);
    }

}
