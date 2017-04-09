package com.ivo.qqreader.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ivo.qqreader.R;
import com.ivo.qqreader.app.InfoService;
import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.base.BaseFra;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public abstract class InfoFra extends BaseFra {

    protected abstract int actionTag();

    protected abstract  boolean supportLoadMore();

    @Override
    protected int layoutResId() {
        return R.layout.frg_info;
    }

    @Override
    protected void init() {
        AppComponentProvider.provide().inject(this);
        initSwipeRefreshLayout();
        initRecycleView();
    }


    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setColorSchemeColors(colorPrimary);
//        swipeRefreshLayout.setOnRefreshListener(this::loadSpot);
    }

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    InfoAdapter infoAdapter;

    private void initRecycleView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(infoAdapter = new InfoAdapter(R.layout.item_info));
        recyclerView.addItemDecoration(new ItemDecoration());

//        infoAdapter.setAutoLoadMoreSize(10);
        infoAdapter.setOnLoadMoreListener(() -> {
                loadMore();
        }, recyclerView);
    }

    @Inject
    InfoService infoService;

    private Observable<InfoResponse> s(int actionTag, int papestamp) {
        return infoService.listDispatch("topicstream", actionTag, 1, papestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        swipeRefreshLayout.setRefreshing(true);
        loadSpot();
    }

    int pagestamp =1;
    private void loadSpot() {
        s(actionTag(), pagestamp)
                .subscribe(new Subscriber<InfoResponse>() {
                    @Override
                    public void onCompleted() {
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(InfoResponse infoResponse) {
                        List<InfoResponse.InfosBean.Info> infos = new ArrayList<>();
                        for (InfoResponse.InfosBean infosBean : infoResponse.getInfos()) {
                            infos.add(infosBean.getInfo());
                        }
                        infoAdapter.setNewData(infos);
                        pagestamp++;
                    }
                });
    }


    private void loadMore() {
        s(actionTag(), pagestamp)
                .subscribe(new Subscriber<InfoResponse>() {
                    @Override
                    public void onCompleted() {
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(InfoResponse infoResponse) {
                        List<InfoResponse.InfosBean.Info> infos = new ArrayList<>();
                        for (InfoResponse.InfosBean infosBean : infoResponse.getInfos()) {
                            infos.add(infosBean.getInfo());
                        }
                        infoAdapter.addData(infos);
                        pagestamp++;
                        infoAdapter.loadMoreComplete();
                    }
                });
    }

}
