package com.ivo.qqreader.main;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ivo.qqreader.R;
import com.ivo.qqreader.main.watcher.BackPressWatcher;
import com.ivo.qqreader.navigate.RoutePath;
import com.ivo.qqreader.sidebar.SidebarFra;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;
import me.yokeyword.fragmentation.SupportActivity;
import qiu.niorgai.StatusBarCompat;

@Route(path = RoutePath.MAIN)
public class MainAct extends SupportActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        StatusBarCompat.translucentStatusBar(this);
        ButterKnife.bind(this);
        addBackPressWatcher();
        addSidebar();
        s();
    }

    private void addSidebar() {
        loadRootFragment(R.id.sidebar_container, SidebarFra.newInstance());
    }

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    private BackPressWatcher backPressWatcher;

    private void addBackPressWatcher() {
        backPressWatcher = new BackPressWatcher(drawerLayout);
    }


    @Override
    public void onBackPressedSupport() {
        if (!backPressWatcher.onBackPressed()) {
            super.onBackPressedSupport();
        }
    }

    @BindView(R.id.pageBottomTabLayout)
    PageBottomTabLayout pageBottomTabLayout;

    private void s() {
        NavigationController navigationController = pageBottomTabLayout.custom()
                .addItem(newItem(R.drawable.maintab_bookstand_icon, R.drawable.maintab_bookstand_icon_hover, "书架"))
                .addItem(newItem(R.drawable.maintab_city_icon, R.drawable.maintab_city_icon_hover, "精选"))
                .addItem(newItem(R.drawable.maintab_stack_icon, R.drawable.maintab_stack_icon_press, "书城"))
                .addItem(newItem(R.drawable.maintab_category_icon, R.drawable.maintab_category_icon_hover, "发现"))
                        .build();
        navigationController.setSelect(0);
        navigationController.setHasMessage(3,true);
    }

    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    @BindColor(R.color.md_grey_400)
    int md_grey_400;

    private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {
        NormalItemView normalItemView = new NormalItemView(this);
        normalItemView.initialize(drawable, checkedDrawable, text);
        normalItemView.setTextDefaultColor(md_grey_400);
        normalItemView.setTextCheckedColor(colorPrimary);
        return normalItemView;
    }


}
