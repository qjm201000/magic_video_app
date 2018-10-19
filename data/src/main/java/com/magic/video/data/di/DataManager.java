package com.magic.video.data.di;

import com.magic.video.data.di.component.DaggerDataComponent;
import com.magic.video.data.di.module.DataModule;
import com.magic.video.data.repository.Repository;

import javax.inject.Inject;

public class DataManager {
    @Inject
    public Repository mRepository;
    public DataManager() {
        DaggerDataComponent.builder().dataModule(new DataModule()).build().injectDataManager(this);
    }
}
