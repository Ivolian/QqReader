package com.ivo.qqreader.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class BaseAct extends SupportActivity {

    protected abstract int layoutResId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResId());
        ButterKnife.bind(this);
        init(savedInstanceState);
    }

    protected void init(Bundle savedInstanceState){

    }

}
