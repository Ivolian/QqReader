package com.ivo.qqreader.app;

import com.ivo.qqreader.bookStack.category.response.BookCategoryResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface BookService {

    @GET("queryOperation")
    Observable<BookCategoryResponse> queryOperation(@Query("categoryFlag") Integer categoryFlag);

}
