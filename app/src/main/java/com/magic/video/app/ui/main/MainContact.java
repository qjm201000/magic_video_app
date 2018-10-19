package com.magic.video.app.ui.main;



import com.magic.video.app.base.mvp.BaseModel;
import com.magic.video.app.base.mvp.BasePresenter;
import com.magic.video.app.base.mvp.BaseView;
import com.magic.video.data.bean.MainResultBean;

public class MainContact {
    interface Presenter extends BasePresenter<View, Model> {
        void onLoadData();
        MainResultBean getData();
    }
    interface View extends BaseView {
        void onLoadDataSuccess();
        void onLoadDataError(String message);
    }
    interface Model extends BaseModel {
        //对数据进行处理完后返回给View或者是Presenter
        MainResultBean disPoseNewsBean(MainResultBean newsBean);
    }
}
