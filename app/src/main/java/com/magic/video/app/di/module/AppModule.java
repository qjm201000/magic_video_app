package com.magic.video.app.di.module;

import android.app.Application;

import com.magic.video.data.di.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application mApplication;
    public AppModule(Application application) {
        mApplication = application;
    }

    /**
     * 提供单例Application
     * @return
     */
    @Singleton
    @Provides
    public Application provideApplication() {
        return mApplication;
    }

    /**
     * 提供单例DataManager
     * @return
     */
    @Singleton
    @Provides
    public DataManager provideDataManager() {
        return new DataManager();
    }
}
