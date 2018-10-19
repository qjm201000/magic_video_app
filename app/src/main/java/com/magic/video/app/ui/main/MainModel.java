package com.magic.video.app.ui.main;

import com.magic.video.data.bean.MainResultBean;

public class MainModel implements MainContact.Model {
    @Override
    public MainResultBean disPoseNewsBean(MainResultBean newsBean) {
        newsBean.getStories().get(0).setTitle("我是经过处理后的标题");
        return newsBean;
    }
}
