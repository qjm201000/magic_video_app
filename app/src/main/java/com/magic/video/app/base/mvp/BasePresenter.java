package com.magic.video.app.base.mvp;

public interface BasePresenter<V extends BaseView, M extends BaseModel> {
    void onAttachView(V view, M model);
    void onDetachView(V View);
}
