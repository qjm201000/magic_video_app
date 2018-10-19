package com.magic.video.app.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.magic.video.app.R;
import com.magic.video.app.base.app.BaseMVPActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseMVPActivity<MainPresenter, MainModel> implements MainContact.View {
    @BindView(R.id.btn_main_start)
    Button mBtnMainStart;
    @BindView(R.id.tv_main_content)
    TextView mTvMainContent;

    @Override
    protected int onGetLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void onLoadDataSuccess() {
        mTvMainContent.setText(mPresenter.getData().toString());
        Log.d(TAG, "onLoadDataSuccess,data:" + mPresenter.getData().toString());
    }

    @Override
    public void onLoadDataError(String message) {
        Log.d(TAG, "onLoadDataError,message:" + message);
    }

    @OnClick(R.id.btn_main_start)
    public void onViewClicked() {
        mPresenter.onLoadData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}
