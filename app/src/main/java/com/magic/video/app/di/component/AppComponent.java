package com.magic.video.app.di.component;

import android.app.Application;

import com.magic.video.app.App;
import com.magic.video.app.di.module.AppModule;
import com.magic.video.data.di.DataManager;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void injectApp(App app);

    Application getApplication();

    DataManager getDataManeger();
}
