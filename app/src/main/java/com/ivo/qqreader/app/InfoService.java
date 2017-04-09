package com.ivo.qqreader.app;

import com.ivo.qqreader.discover.InfoResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface InfoService {

    @GET("listDispatch")
    Observable<InfoResponse> listDispatch(@Query("action") String action,
                                          @Query("actionTag") Integer actionTag,
                                          @Query("actionId") Integer actionId,
                                          @Query("pagestamp") Integer pagestamp);

}
