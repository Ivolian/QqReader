package com.ivo.qqreader.bookStack.category;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;

import java.util.List;

public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public MultipleItemQuickAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(MultipleItem.TEXT, R.layout.item_book_category_1);
        addItemType(MultipleItem.IMG, R.layout.item_book_category_2);
    }



//    public MultipleItemQuickAdapter() {
//    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.TEXT:
//                helper.setImageUrl(R.id.tv, item.getContent());
                break;
            case MultipleItem.IMG:
//                helper.setImageUrl(R.id.iv, item.getContent());
                break;
        }
    }

}