package com.ivo.qqreader.discover.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.ivo.qqreader.R;
import com.ivo.qqreader.discover.network.InfoService;
import com.ivo.qqreader.base.BaseFra;
import com.ivo.qqreader.discover.dagger.DiscoverComponentProvider;
import com.ivo.qqreader.discover.info.response.InfoResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public abstract class InfoFra extends BaseFra {

    protected abstract int actionTag();

    protected abstract boolean supportLoadMore();

    @Override
    protected int layoutResId() {
        return R.layout.frg_info;
    }

    @Override
    protected void init() {
        DiscoverComponentProvider.provide().inject(this);
        initSwipeRefreshLayout();
        initRecycleView();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        swipeRefreshLayout.setRefreshing(true);
        loadFirst();
    }

    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setColorSchemeColors(colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(this::loadFirst);
    }

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private InfoAdapter infoAdapter;

    private void initRecycleView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new InfoItemDecoration());
        recyclerView.setAdapter(infoAdapter = new InfoAdapter());
        addLoadMoreListenerIfNeed();
    }

    private void addLoadMoreListenerIfNeed() {
        if (supportLoadMore()) {
            infoAdapter.setOnLoadMoreListener(this::loadNext, recyclerView);
        }
    }

    @Inject
    InfoService infoService;

    private Observable<InfoResponse> loadInfo() {
        return infoService.listDispatch("topicstream", actionTag(), 1, pagestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private int pagestamp = 1;

    private void loadFirst() {
        pagestamp = 1;
        loadInfo().subscribe(new Subscriber<InfoResponse>() {
            @Override
            public void onCompleted() {
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {
                showErrorView();
            }

            @Override
            public void onNext(InfoResponse infoResponse) {
                hideErrorView();
                infoAdapter.setNewData(transform(infoResponse));
                pagestamp++;
            }
        });
    }

    private void loadNext() {
        loadInfo().subscribe(new Subscriber<InfoResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                showErrorView();
            }

            @Override
            public void onNext(InfoResponse infoResponse) {
                hideErrorView();
                infoAdapter.loadMoreComplete();
                infoAdapter.addData(transform(infoResponse));
                pagestamp++;
            }
        });
    }

    @SuppressWarnings("Convert2streamapi")
    private List<InfoResponse.InfosBean.Info> transform(InfoResponse infoResponse) {
        List<InfoResponse.InfosBean.Info> infos = new ArrayList<>();
        for (InfoResponse.InfosBean infosBean : infoResponse.getInfos()) {
            infos.add(infosBean.getInfo());
        }
        return infos;
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
    public void reloadOnClick() {
        swipeRefreshLayout.setRefreshing(true);
        loadFirst();
    }

}
