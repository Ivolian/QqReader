package com.ivo.qqreader.bookshelf.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.gelitenight.waveview.library.WaveView;
import com.ivo.qqreader.R;
import com.ivo.qqreader.bookshelf.dagger.BookshelfComponentProvider;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;

public class BookHeaderView extends FrameLayout {

    public BookHeaderView(@NonNull Context context) {
        this(context, null);
    }

    public BookHeaderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookHeaderView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.header_book, this, true);
        ButterKnife.bind(this);
        BookshelfComponentProvider.provide().inject(this);
        initViews();
    }

    private void initViews() {
        initWaveView();
        initIvGift();
        initTvCheckIn();
    }

    @BindView(R.id.waveView)
    WaveView waveView;

    private void initWaveView() {
        WaveHelper waveHelper = new WaveHelper(waveView);
        int color = ColorUtils.setAlphaComponent(md_white, 10);
        waveView.setWaveColor(color, color);
        waveHelper.start();
    }

    @BindView(R.id.ivGift)
    ImageView ivGift;

    @BindColor(R.color.md_grey_50)
    int md_grey_50;

    private void initIvGift() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(10000);
        gradientDrawable.setStroke(10, ColorUtils.setAlphaComponent(md_grey_50, 100));
        ivGift.setBackground(gradientDrawable);
    }

    @BindColor(R.color.md_white)
    int md_white;

    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    @BindView(R.id.tvCheckIn)
    TextView tvCheckIn;

    private void initTvCheckIn() {
        GradientDrawable unpressed = new GradientDrawable();
        unpressed.setCornerRadius(10000);
        unpressed.setStroke(3, md_white);

        GradientDrawable pressed = new GradientDrawable();
        pressed.setCornerRadius(10000);
        pressed.setStroke(3, md_white);
        pressed.setColor(md_white);


        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressed);
        stateListDrawable.addState(new int[]{-android.R.attr.state_pressed}, unpressed);

        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_pressed},
                        new int[]{-android.R.attr.state_pressed}
                },
                new int[]{colorPrimary, md_white}
        );

        tvCheckIn.setTextColor(colorStateList);
        tvCheckIn.setPadding(40, 12, 40, 12);
        tvCheckIn.setBackground(stateListDrawable);
        tvCheckIn.setClickable(true);

    }

    public void zoom() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.95f, 1.06f, 0.98f, 1.03f, 1f);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(animation -> {
            float value = (float) animation.getAnimatedValue();
            tvCheckIn.setScaleX(value);
            tvCheckIn.setScaleY(value);
        });
        valueAnimator.start();
    }

}
