package com.ivo.qqreader.bookStack.category;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppComponentProvider;
import com.ivo.qqreader.bookStack.category.renderer.CategoryRenderer;
import com.ivo.qqreader.bookStack.category.renderer.CountRenderer;
import com.ivo.qqreader.bookStack.category.renderer.LineRenderer;
import com.ivo.qqreader.bookStack.category.renderer.RecmdRenderer;

import java.util.List;

import javax.inject.Inject;

public class BookCategoryAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public BookCategoryAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(ItemType.COUNT, R.layout.item_count);
        addItemType(ItemType.RECMD, R.layout.item_recmd);
//        addItemType(ItemType.BOY_CATEGORY, R.layout.item_category);
        addItemType(ItemType.LINE, R.layout.item_line);
        addItemType(ItemType.CATEGORY, R.layout.item_category);
        AppComponentProvider.provide().inject(this);
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
//            case ItemType.GIRL_CATEGORY:
//                girlCategoryRenderer.render(viewHolder, item);
//                break;
            case ItemType.LINE:
                lineRenderer.render(viewHolder, item);
                break;

        }
    }


}