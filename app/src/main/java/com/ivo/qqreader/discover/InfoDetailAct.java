package com.ivo.qqreader.discover;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.f2prateek.dart.InjectExtra;
import com.ivo.qqreader.Key;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.helper.ToastHelper;
import com.ivo.qqreader.base.SwipeBackAct;
import com.ivo.qqreader.discover.dagger.DiscoverComponentProvider;
import com.ivo.qqreader.navigate.RoutePath;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = RoutePath.INFO_DETAIL_ACT)
public class InfoDetailAct extends SwipeBackAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_info_detail;
    }

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @InjectExtra(Key.INFO_TITLE)
    String infoTitle;

    @Override
    protected void init(Bundle savedInstanceState) {
        DiscoverComponentProvider.provide().inject(this);
        tvTitle.setText(infoTitle);
        initWebView();
    }

    @BindView(R.id.webView)
    WebView webView;

    @InjectExtra(Key.INFO_URL)
    String infoUrl;

    private void initWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        String user_agent = "Mozilla/5.0 (Macintosh; U; PPC Mac OS X; en) AppleWebKit/124 (KHTML, like Gecko) Safari/125.1";
        webView.getSettings().setUserAgentString(user_agent);
        webView.loadUrl(infoUrl);
    }

    @OnClick(R.id.ivBack)
    public void backOnClick() {
        super.onBackPressedSupport();
    }

    @Inject
    ToastHelper toastHelper;

    @OnClick(R.id.ivShare)
    public void shareOnClick() {
        toastHelper.notSupport("分享");
    }

}
