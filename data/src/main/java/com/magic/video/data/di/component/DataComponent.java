package com.magic.video.data.di.component;

import com.magic.video.data.di.DataManager;
import com.magic.video.data.di.module.DataModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DataModule.class)
public interface DataComponent {
    void injectDataManager(DataManager dataManager);
}
