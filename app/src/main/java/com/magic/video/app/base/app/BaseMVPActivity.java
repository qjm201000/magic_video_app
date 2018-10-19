package com.magic.video.app.base.app;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.magic.video.app.base.mvp.BaseModel;
import com.magic.video.app.base.mvp.BasePresenter;
import com.magic.video.app.base.mvp.BaseView;
import com.magic.video.app.util.TUtil;

public abstract class BaseMVPActivity<P extends  BasePresenter, M extends BaseModel> extends BaseActivity implements BaseView {
    protected P mPresenter;
    protected M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        //绑定
        mPresenter.onAttachView(this, mModel);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        //解除绑定
        if (null != mPresenter) {
            mPresenter.onDetachView(this);
        }
    }
}
