package com.ivo.qqreader.bookstack.category;

import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.Key;
import com.ivo.qqreader.R;
import com.ivo.qqreader.bookstack.category.renderer.CategoryRenderer;
import com.ivo.qqreader.bookstack.category.renderer.CountRenderer;
import com.ivo.qqreader.bookstack.category.renderer.LineRenderer;
import com.ivo.qqreader.bookstack.category.renderer.RecmdRenderer;
import com.ivo.qqreader.bookstack.category.response.BookCategoryResponse;
import com.ivo.qqreader.bookstack.dagger.BookstackComponentProvider;
import com.ivo.qqreader.navigate.RoutePath;
import com.jakewharton.rxbinding.view.RxView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class BookCategoryAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    BookCategoryAdapter(List<MultiItemEntity> data) {
        super(data);
        BookstackComponentProvider.provide().inject(this);
        addItemType(ItemType.COUNT, R.layout.item_count);
        addItemType(ItemType.RECMD, R.layout.item_recmd);
        addItemType(ItemType.LINE, R.layout.item_line);
        addItemType(ItemType.CATEGORY, R.layout.item_category);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
        addListener(viewHolder.getConvertView(), viewHolder, viewType);
        return viewHolder;
    }

    private void addListener(View itemView, BaseViewHolder viewHolder, int viewType) {
        if (viewType == ItemType.CATEGORY) {
            RxView.clicks(itemView)
                    .throttleFirst(1, TimeUnit.SECONDS)
                    .map(aVoid -> (BookCategoryResponse.Category) getItem(viewHolder.getAdapterPosition()))
                    .subscribe(category -> ARouter.getInstance().build(RoutePath.BOOK_CATEGORY_DETAIL_ACT)
                            .withString(Key.ACTION_ID, category.getActionId() + "")
                            .withString(Key.TITLE, category.getCategoryName())
                            .navigation()
                    );
        }
    }

    @Inject
    CountRenderer countRenderer;

    @Inject
    RecmdRenderer recmdRenderer;

    @Inject
    CategoryRenderer categoryRenderer;

    @Inject
    LineRenderer lineRenderer;

    @Override
    protected void convert(BaseViewHolder viewHolder, MultiItemEntity item) {
        switch (viewHolder.getItemViewType()) {
            case ItemType.COUNT:
                countRenderer.render(viewHolder, item);
                break;
            case ItemType.RECMD:
                recmdRenderer.render(viewHolder, item);
                break;
            case ItemType.CATEGORY:
                categoryRenderer.render(viewHolder, item);
                break;
            case ItemType.LINE:
                lineRenderer.render(viewHolder, item);
                break;
        }
    }

    public static class ItemType {
        public static final int COUNT = 0;
        public static final int LINE = 1;
        public static final int RECMD = 2;
        public static final int CATEGORY = 3;
    }

}