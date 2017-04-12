package com.ivo.qqreader.bookshelf.network;

import com.ivo.qqreader.bookshelf.model.BookResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface BookService {

    @SuppressWarnings("SameParameterValue")
    @GET("listDispatch")
    Observable<BookResponse> getBooks(@Query("action") String action, @Query("actionTag") String actionTag
            , @Query("actionId") String actionId, @Query("pagestamp") Integer pagestamp);

}
