package com.ivo.qqreader.bookStack.category.renderer;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ivo.qqreader.R;
import com.ivo.qqreader.app.dagger.AppScope;
import com.ivo.qqreader.bookStack.category.response.BookCategoryResponse1;
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
        BookCategoryResponse1.Count count = (BookCategoryResponse1.Count) item;

        String bookCount = count.getBookCount() + "";
        String newBookCount = count.getNewBookCount() + "";
        String text = "原创分类公" + bookCount + "册,本周新增" + newBookCount + "册";
        tvCount.setText(text);

        addLinks(tvCount, bookCount, newBookCount);
    }

    private void addLinks(TextView tvCount, String bookCount, String newBookCount) {
        int linkColor = ContextCompat.getColor(context, R.color.md_red_300);
        Link link = new Link(bookCount)
                .setTextColor(linkColor)
                .setUnderlined(false);
        Link link2 = new Link(newBookCount)
                .setTextColor(linkColor)
                .setUnderlined(false);
        LinkBuilder.on(tvCount)
                .addLink(link)
                .addLink(link2)
                .build();
    }

}
