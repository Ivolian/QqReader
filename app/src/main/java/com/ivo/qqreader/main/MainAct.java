package com.ivo.qqreader.main;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.ViewDragHelper;
import android.view.Gravity;
import android.view.ViewConfiguration;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.ivo.qqreader.R;
import com.ivo.qqreader.base.SwipeBackAct;
import com.ivo.qqreader.bus.BusAction;
import com.ivo.qqreader.navigate.RoutePath;
import com.ivo.qqreader.sidebar.SidebarFra;

import java.lang.reflect.Field;

import butterknife.BindColor;
import butterknife.BindView;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;
import qiu.niorgai.StatusBarCompat;

@Route(path = RoutePath.MAIN_ACT)
public class MainAct extends SwipeBackAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_main;
    }

    @Override
    protected boolean useRxBus() {
        return true;
    }

    @Override
    protected boolean isMain() {
        return true;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        StatusBarCompat.translucentStatusBar(this);
        initDrawerLayout();
        if (savedInstanceState == null) {
            addSidebarFra();
        }
        initViewPager();
        initMainTab();
        addBackPressConsumer();
    }

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    private void initDrawerLayout() {
        drawerLayout.setDrawerShadow(R.drawable.sidebar_shadow, Gravity.START);
        try {
            changeDrawerSensitivity();
        } catch (Exception e) {
            // do nothing
        }
    }

    private void changeDrawerSensitivity() throws Exception {
        Field field = drawerLayout.getClass().getDeclaredField("mLeftDragger");
        field.setAccessible(true);
        ViewDragHelper mLeftDragger = (ViewDragHelper) field.get(drawerLayout);
        field = mLeftDragger.getClass().getDeclaredField("mTouchSlop");
        field.setAccessible(true);
        int touchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        touchSlop = (int) (touchSlop * (1 / 0.5));
        field.set(mLeftDragger, touchSlop);
    }

    private void addSidebarFra() {
        loadRootFragment(R.id.sidebar_container, new SidebarFra());
    }

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private void initViewPager() {
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
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
        setHasMessage(navigationController);
    }

    private void setHasMessage(NavigationController navigationController) {
        int pos = 3;
        navigationController.setHasMessage(pos, true);
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int i, int i1) {
                if (i == pos) {
                    navigationController.setHasMessage(pos, false);
                }
                if (i == i1) {
                    RxBus.get().post(BusAction.BACK_TO_TOP, new Object());
                }
            }

            @Override
            public void onRepeat(int i) {

            }
        });
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

    private BackPressConsumer backPressConsumer;

    private void addBackPressConsumer() {
        backPressConsumer = new BackPressConsumer(drawerLayout);
    }

    @Override
    public void onBackPressedSupport() {
        if (!backPressConsumer.onBackPressed()) {
            super.onBackPressedSupport();
        }
    }

    @Subscribe(tags = {@Tag(BusAction.OPEN_DRAWER)})
    public void openDrawer(Object o) {
        int gravity = Gravity.START;
        if (!drawerLayout.isDrawerOpen(gravity)) {
            drawerLayout.openDrawer(gravity);
        }
    }

}
