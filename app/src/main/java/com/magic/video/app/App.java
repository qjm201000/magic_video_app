package com.magic.video.app;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.magic.video.app.di.component.AppComponent;
import com.magic.video.app.di.component.DaggerAppComponent;
import com.magic.video.app.di.module.AppModule;

public class App extends Application {
    private AppComponent mAppComponent;
    private static App mApp;
    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        mAppComponent.injectApp(this);
        if (BuildConfig.DEBUG) {
            Stetho.initialize(
                    Stetho.newInitializerBuilder(this)
                            .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                            .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                            .build()
            );
        }
    }
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
    public static App getInstance() {
        return mApp;
    }
}
