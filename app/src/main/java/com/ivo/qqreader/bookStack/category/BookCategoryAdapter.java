package com.ivo.qqreader.bookStack.category;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppComponentProvider;

import java.util.List;

import javax.inject.Inject;

public class BookCategoryAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public BookCategoryAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(ItemType.COUNT, R.layout.item_count);
        addItemType(ItemType.RECMD, R.layout.item_recmd);
        addItemType(ItemType.BOY_CATEGORY, R.layout.item_category);
        addItemType(ItemType.LINE, R.layout.item_line);
        addItemType(ItemType.GIRL_CATEGORY, R.layout.item_category);
        AppComponentProvider.provide().inject(this);
    }

    @Inject
    CountRenderer countRenderer;

    @Override
    protected void convert(BaseViewHolder viewHolder, MultiItemEntity item) {
        switch (viewHolder.getItemViewType()) {
            case ItemType.COUNT:
                countRenderer.render(viewHolder, item);
                break;
        }
    }



}