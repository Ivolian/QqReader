package com.ivo.qqreader.bookStack.ui;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
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

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HorseTabLayout extends LinearLayout {

    public void setTextSize(int size) {
        tab1.setTextSize(size);
        tab2.setTextSize(size);
    }

    String sys = "sys";

    String position = "position";

    int pos= 0;
    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(sys, super.onSaveInstanceState());
        bundle.putInt(position,pos);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            int pos = bundle.getInt(position, 0);
            super.onRestoreInstanceState(bundle.getParcelable(sys));

//            if (pos != 0 && mNavigationController != null) {
//                mNavigationController.setSelect(pos);
//            }

            viewPager.setCurrentItem(pos);

            return;
        }
        super.onRestoreInstanceState(state);
    }


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
        setBg();
        initIndicatorDrawable();
        tab1.setTextColor(colorPrimary);
    }

    private int radius = 10000;

    private void setBg() {
        GradientDrawable bg = new GradientDrawable();
        int stroke = 5;
        bg.setStroke(stroke, Color.WHITE);
        bg.setCornerRadius(radius);
        setBackground(bg);
    }

    private GradientDrawable indicatorDrawable = new GradientDrawable();

    private void initIndicatorDrawable() {
        indicatorDrawable.setCornerRadius(radius);
        indicatorDrawable.setColor(Color.WHITE);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        indicatorDrawable.setBounds(0, 0, getWidth() / 2, getHeight());
    }


    @Override
    protected void onDraw(Canvas canvas) {
        if (indicatorDrawable != null) {
            indicatorDrawable.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @BindView(R.id.tab1)
    TextView tab1;

    @BindView(R.id.tab2)
    TextView tab2;

    private ViewPager viewPager;

    private ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        addOnPageChangeListener();
    }


    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    private void addOnPageChangeListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // 0 -> 1 => 0
                if (positionOffset == 0) {
                    return;
                }

                int color1 = (Integer) argbEvaluator.evaluate(positionOffset, colorPrimary, Color.WHITE);
                int color2 = (Integer) argbEvaluator.evaluate(1 - positionOffset, colorPrimary, Color.WHITE);
                tab1.setTextColor(color1);
                tab2.setTextColor(color2);

                int left = (int) (getWidth() / 2 * (positionOffset));
                indicatorDrawable.setBounds(left, 0, left + getWidth() / 2, getHeight());

                invalidate();
            }

            @Override
            public void onPageSelected(int position) {
        pos = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
