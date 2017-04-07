package com.ivo.qqreader.bookStack.category;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;

import java.util.List;

public class BookCategoryAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public BookCategoryAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(ItemType.COUNT, R.layout.item_count);
        addItemType(ItemType.RECMD, R.layout.item_recmd);
        addItemType(ItemType.BOY_CATEGORY, R.layout.item_category);
        addItemType(ItemType.LINE, R.layout.item_line);
        addItemType(ItemType.GIRL_CATEGORY, R.layout.item_category);
    }


//    public MultipleItemQuickAdapter() {
//    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()) {
//            case MultipleItem.TEXT:
////                helper.setImageUrl(R.id.tv, item.getContent());
//                break;
//            case MultipleItem.IMG:
////                helper.setImageUrl(R.id.iv, item.getContent());
//                break;
        }
    }

}