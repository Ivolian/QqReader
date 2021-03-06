package com.ivo.qqreader.app.helper;

import com.ivo.qqreader.app.AppConfig;
import com.ivo.qqreader.app.dagger.App;

@App
public class BookCoverHelper {

    // 将 bookId 转化为封面地址
    public static String coverUrl(String bookId) {
        // 239254
        int length = bookId.length();
        // 254
        String latter = bookId.substring(length - 3, length);
        // 054 => 54
        if (latter.startsWith("0")) {
            // 目前只发现一个0的情况
            latter = latter.substring(1, 3);
        }
        // http://wfqqreader.3g.qq.com/cover/254/239254/t5_239254.jpg
        return AppConfig.BASE_COVER_URL + latter + "/" + bookId + "/t5_" + bookId + ".jpg";
    }

}
