package com.magic.video.app.base.mvp;

import com.magic.video.app.App;
import com.magic.video.data.di.DataManager;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public abstract class MVPPresenter<V extends BaseView, M extends BaseModel> implements BasePresenter<V, M> {
    protected V mView;
    protected M mModel;
    protected DataManager mDataManager;
    private CompositeSubscription mCompositeSubscription;

    public MVPPresenter() {
        //获取data module的DataManeger
        mDataManager = App.getInstance().getAppComponent().getDataManeger();
    }

    @Override
    public void onAttachView(V view, M model) {
        this.mView = view;
        this.mModel = model;
    }

    @Override
    public void onDetachView(V View) {
        onUnSubscribe();
    }

    /**
     * rxJava取消订阅
     */ private void onUnSubscribe() {
         if (null != mCompositeSubscription && mCompositeSubscription.hasSubscriptions()) {
             mCompositeSubscription.unsubscribe();
         }
     }

    /**
     * 统一处理观察者与被观察者的线程
     * @param observable
     * @param subscriber
     * @param <T>
     */ public <T> void addSubscription(Observable<T> observable, Subscriber<T> subscriber) {
         if (null == mCompositeSubscription) {
             mCompositeSubscription = new CompositeSubscription();
         }
         Subscription subscribe = observable.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(subscriber);
         mCompositeSubscription.add(subscribe);
     }
}
