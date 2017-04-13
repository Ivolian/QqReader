package com.ivo.qqreader.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.f2prateek.dart.Dart;
import com.hwangjr.rxbus.RxBus;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class BaseAct extends SupportActivity {

    protected abstract int layoutResId();

    protected boolean useRxBus() {
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dart.inject(this);
        setContentView(layoutResId());
        ButterKnife.bind(this);
        init(savedInstanceState);
        if (useRxBus()) {
            RxBus.get().register(this);
        }
    }

    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (useRxBus()) {
            RxBus.get().unregister(this);
        }
    }

}
