package com.magic.video.data.api;

import com.magic.video.data.bean.MainResultBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * 网络接口api
 */
public interface ApiService {
    @GET("news/latest")
    Observable<MainResultBean> requestMainData();
}
