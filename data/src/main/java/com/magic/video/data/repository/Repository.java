package com.magic.video.data.repository;

import com.magic.video.data.api.ApiService;
import com.magic.video.data.bean.MainResultBean;

import rx.Observable;

/**
 * 网络请求的仓库
 */
public class Repository {
    private ApiService mApiService;
    public Repository(ApiService apiService)
    {
        mApiService = apiService;
    }
    public Observable<MainResultBean> requestMainData()
    {
        return mApiService.requestMainData();
    }
}
