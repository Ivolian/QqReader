package com.ivo.qqreader.app.helper;

import android.content.Context;

import com.ivo.qqreader.app.dagger.AppScope;
import com.sdsmdg.tastytoast.TastyToast;

import javax.inject.Inject;

@AppScope
public class ToastHelper {

    private final Context context;

    @Inject
    ToastHelper(Context context) {
        this.context = context;
    }

    public void error(String msg) {
        TastyToast.makeText(context, msg, TastyToast.LENGTH_SHORT, TastyToast.ERROR);
    }

    public void success(String msg) {
        TastyToast.makeText(context, msg, TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
    }

    public void info(String msg) {
        TastyToast.makeText(context, msg, TastyToast.LENGTH_SHORT, TastyToast.INFO);
    }

    public void wontDevelop(String name) {
        info(name + "将不会开发");
    }

    public void mayByDevelop(String name) {
        success(name + "等待开发");
    }

}
