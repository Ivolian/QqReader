package com.ivo.qqreader.main;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.ViewDragHelper;
import android.view.Gravity;
import android.view.ViewConfiguration;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ivo.qqreader.R;
import com.ivo.qqreader.main.adapter.MainPagerAdapter;
import com.ivo.qqreader.main.watcher.BackPressWatcher;
import com.ivo.qqreader.navigate.RoutePath;
import com.ivo.qqreader.sidebar.SidebarFra;

import java.lang.reflect.Field;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;
import me.yokeyword.fragmentation.SupportActivity;
import qiu.niorgai.StatusBarCompat;

@Route(path = RoutePath.MAIN_ACT)
public class MainAct extends SupportActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarCompat.translucentStatusBar(this);
        setContentView(R.layout.act_main);
        ButterKnife.bind(this);
        initDrawerLayout();
        if (savedInstanceState == null) {
            addSidebarFra();
        }
        initViewPager();
        initMainTab();
        addBackPressWatcher();
    }

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    private void initDrawerLayout() {
        drawerLayout.setDrawerShadow(R.drawable.sidebar_shadow, Gravity.START);
        try {
            changeSensitivity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changeSensitivity() throws Exception {
        Field field = drawerLayout.getClass().getDeclaredField("mLeftDragger");
        field.setAccessible(true);
        ViewDragHelper viewDragHelper = (ViewDragHelper) field.get(drawerLayout);

        field = viewDragHelper.getClass().getDeclaredField("mTouchSlop");
        field.setAccessible(true);

        int touchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        touchSlop = (int) (touchSlop * (1 / 0.5));
        field.set(viewDragHelper, touchSlop);
    }

    private void addSidebarFra() {
        loadRootFragment(R.id.sidebar_container, new SidebarFra());
    }

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private void initViewPager() {
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainPagerAdapter);
    }

    @BindView(R.id.mainTab)
    PageBottomTabLayout mainTab;

    private void initMainTab() {
        NavigationController navigationController = mainTab.custom()
                .addItem(newItem(R.drawable.maintab_bookstand_icon, R.drawable.maintab_bookstand_icon_hover, "书架"))
                .addItem(newItem(R.drawable.maintab_city_icon, R.drawable.maintab_city_icon_hover, "精选"))
                .addItem(newItem(R.drawable.maintab_stack_icon, R.drawable.maintab_stack_icon_press, "书城"))
                .addItem(newItem(R.drawable.maintab_category_icon, R.drawable.maintab_category_icon_hover, "发现"))
                .build();
        navigationController.setupWithViewPager(viewPager);
        navigationController.setSelect(0);
        navigationController.setHasMessage(3, true);
    }

    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    @BindColor(R.color.md_grey_500)
    int mdGrey400;

    private BaseTabItem newItem(@DrawableRes int drawableRes, @DrawableRes int checkedDrawableRes, String title) {
        NormalItemView normalItemView = new NormalItemView(this);
        normalItemView.initialize(drawableRes, checkedDrawableRes, title);
        normalItemView.setTextDefaultColor(mdGrey400);
        normalItemView.setTextCheckedColor(colorPrimary);
        return normalItemView;
    }

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

}
