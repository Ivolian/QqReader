package com.ivo.qqreader.sidebar.item;

import com.ivo.qqreader.R;
import com.ivo.qqreader.sidebar.item.model.SidebarItem;

import java.util.Arrays;
import java.util.List;

public class SideItemProvider {

    public List<SidebarItem> provide() {
        return Arrays.asList(
                new SidebarItem(R.drawable.profile_account_icon, "我的账户"),
                new SidebarItem(R.drawable.profile_month_icon, "包月特权"),
                new SidebarItem(R.drawable.profile_package_icon, "我的超值包"),
                new SidebarItem(R.drawable.message_icon, "我的消息"),
                new SidebarItem(R.drawable.profile_history_icon, "浏览历史"),
                new SidebarItem(R.drawable.profile_collection_icon, "我的收藏"),
                new SidebarItem(R.drawable.my_gene, "我的基因"),
                new SidebarItem(R.drawable.profile_icon_to_be_writer, "成为作家")
        );
    }

}
