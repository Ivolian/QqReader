package com.ivo.qqreader.app.helper;

import android.content.Context;

import com.ivo.qqreader.app.dagger.App;
import com.sdsmdg.tastytoast.TastyToast;

import javax.inject.Inject;

@App
public class ToastHelper {

    private final Context context;

    @Inject
    ToastHelper(Context context) {
        this.context = context;
    }

    public void error(String msg) {
        TastyToast.makeText(context, msg, TastyToast.LENGTH_SHORT, TastyToast.ERROR);
    }

    private void success(String msg) {
        TastyToast.makeText(context, msg, TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
    }

    public void notSupport(String name) {
        success("不支持" + name);
    }

}
