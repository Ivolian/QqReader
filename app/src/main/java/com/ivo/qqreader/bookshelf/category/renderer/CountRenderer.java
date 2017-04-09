package com.ivo.qqreader.bookshelf.category.renderer;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppScope;
import com.ivo.qqreader.bookshelf.category.response.BookCategoryResponse;
import com.klinker.android.link_builder.Link;
import com.klinker.android.link_builder.LinkBuilder;

import javax.inject.Inject;

@AppScope
public class CountRenderer {

    private final Context context;

    @Inject
    public CountRenderer(Context context) {
        this.context = context;
    }

    public void render(BaseViewHolder viewHolder, MultiItemEntity item) {
        TextView tvCount = viewHolder.getView(R.id.tvCount);
        BookCategoryResponse.Count count = (BookCategoryResponse.Count) item;

        String bookCount = count.getBookCount() + "";
        String newBookCount = count.getNewBookCount() + "";
        String text = "原创分类公" + bookCount + "册,本周新增" + newBookCount + "册";
        tvCount.setText(text);

        addLinks(tvCount, bookCount, newBookCount);
    }

    private void addLinks(TextView tvCount, String bookCount, String newBookCount) {
        LinkBuilder.on(tvCount)
                .addLink(createLink(bookCount))
                .addLink(createLink(newBookCount))
                .build();
    }

    private Link createLink(String text) {
        int linkColor = ContextCompat.getColor(context, R.color.md_red_300);
        return new Link(text)
                .setTextColor(linkColor)
                .setUnderlined(false);
    }

}
