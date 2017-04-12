package com.ivo.qqreader.ui;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.app.helper.DensityHelper;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HorseTabLayout extends LinearLayout {

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("onSaveInstanceState", super.onSaveInstanceState());
        bundle.putFloat("mPositionOffset", mPositionOffset);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            mPositionOffset = bundle.getFloat("mPositionOffset", 0);
            super.onRestoreInstanceState(bundle.getParcelable("onSaveInstanceState"));
            // tab
            return;
        }
        super.onRestoreInstanceState(state);
    }


    // ================== HorseTabLayout

    public HorseTabLayout(Context context) {
        this(context, null);
    }

    public HorseTabLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorseTabLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.horse_tab_layout, this, true);
        ButterKnife.bind(this);
        AppComponentProvider.provide().inject(this);
        setUpBackground();
        setUpIndicatorDrawable();
    }

    @Inject
    DensityHelper densityHelper ;

    @OnClick(R.id.tab1)
    public void tab1() {
        viewPager.setCurrentItem(0, true);
    }

    @OnClick(R.id.tab2)
    public void tab2() {
        viewPager.setCurrentItem(1, true);
    }


    // ================== setTabs

    private float mPositionOffset;

    private final int radius = 10000;

    private void setUpBackground() {
        GradientDrawable bg = new GradientDrawable();
        int stroke = 5;
        bg.setStroke(stroke, white);
        bg.setCornerRadius(radius);
        setBackground(bg);
    }

    private final GradientDrawable indicatorDrawable = new GradientDrawable();

    private void setUpIndicatorDrawable() {
        indicatorDrawable.setCornerRadius(radius);
        indicatorDrawable.setColor(white);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // the canvas on which the background will be drawn
        if (indicatorDrawable != null) {
            int left = (int) (getWidth() / 2 * mPositionOffset);
            indicatorDrawable.setBounds(left, 0, left + getWidth() / 2, getHeight());
            indicatorDrawable.draw(canvas);
        }
        changeTabsColor();
    }


    // ================== changeTabsColor

    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    @BindColor(R.color.md_white)
    int white;

    @BindView(R.id.tab1)
    TextView tab1;

    @BindView(R.id.tab2)
    TextView tab2;

    private final ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    private void changeTabsColor() {
        int color1 = (int) argbEvaluator.evaluate(mPositionOffset, colorPrimary, white);
        int color2 = (int) argbEvaluator.evaluate(1 - mPositionOffset, colorPrimary, white);
        tab1.setTextColor(color1);
        tab2.setTextColor(color2);
    }


    // ================== hookListener

    private ViewPager viewPager;

    public void setUpViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        hookListener();
    }

    private void hookListener() {
        tab1.setText(viewPager.getAdapter().getPageTitle(0));
        tab2.setText(viewPager.getAdapter().getPageTitle(1));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // original: [0,1) -> 0
                // now: (0,1)
                if (positionOffset != 0) {
                    // some fix
                    if (positionOffset < 0.01) {
                        positionOffset = 0;
                    }
                    if (positionOffset > 0.99) {
                        positionOffset = 1;
                    }
                    mPositionOffset = positionOffset;
                    invalidate();
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


}
