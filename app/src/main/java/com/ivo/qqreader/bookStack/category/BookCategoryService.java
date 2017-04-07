package com.ivo.qqreader.bookStack.category;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface  BookCategoryService {

    @GET("queryOperation")
    Observable<BookCategoryResponse> queryOperation(@Query("categoryFlag") Integer categoryFlag);

}
