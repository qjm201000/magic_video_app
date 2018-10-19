package com.magic.video.app.ui.main;

import android.util.Log;

import com.magic.video.app.base.mvp.MVPPresenter;
import com.magic.video.data.bean.MainResultBean;

import rx.Subscriber;

public class MainPresenter extends MVPPresenter<MainContact.View, MainContact.Model> implements MainContact.Presenter {
    private static final String TAG = "MainPresenter";
    private MainResultBean mDataBean;

    @Override
    public void onLoadData() {
        addSubscription(mDataManager.mRepository.requestMainData(), new Subscriber<MainResultBean>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted:");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError,e:" + e.getMessage());
                mView.onLoadDataError(e.getMessage());
            }

            @Override
            public void onNext(MainResultBean resultBean) {
                Log.d(TAG, "onNext:");
                mDataBean = resultBean;
                mView.onLoadDataSuccess();
            }
        });
    }

    @Override
    public MainResultBean getData() {
        return mDataBean;
    }

}
