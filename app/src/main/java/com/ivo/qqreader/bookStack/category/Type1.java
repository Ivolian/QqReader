package com.ivo.qqreader.bookStack.category;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import static com.ivo.qqreader.bookStack.category.MultipleItem.TEXT;

public class Type1 implements MultiItemEntity {

    @Override
    public int getItemType() {
        return TEXT;
    }

}
