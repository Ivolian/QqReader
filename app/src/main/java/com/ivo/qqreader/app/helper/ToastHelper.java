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

    public void show(String msg) {
        TastyToast.makeText(context, msg, TastyToast.LENGTH_SHORT, TastyToast.ERROR);
    }

}
