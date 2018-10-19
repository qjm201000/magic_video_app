package com.magic.video.app.base.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    protected String TAG = "NotInit";
    private Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(onGetLayoutResId());
        ButterKnife.bind(this);
        mContext = this;
        TAG = this.getClass().getSimpleName();
    }

    /**
     * 获取上下文
     * @return
     */
    protected Context getContext() {
        return mContext;
    }

    /**
     * 获取布局资源id
     * @return
     */
    protected abstract int onGetLayoutResId();
}
