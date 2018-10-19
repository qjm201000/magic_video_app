package com.magic.video.data.di.module;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.magic.video.data.api.ApiService;
import com.magic.video.data.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {
    private static final String BASE_UEL = "http://news-at.zhihu.com/api/4/";

    /**
     * 提供单例网络请求仓库
     *
     * @param apiService
     * @return
     */
    @Singleton
    @Provides
    public Repository provideRepository(ApiService apiService) {
        return new Repository(apiService);
    }

    /**
     * 提供单例Api
     *
     * @param retrofit
     * @return
     */
    @Singleton
    @Provides
    public ApiService provideApi(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    /**
     * 提供单例RetrofitClient
     *
     * @param client
     * @param factory
     * @return
     */
    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient client, Converter.Factory factory) {
        return new Retrofit.Builder().baseUrl(BASE_UEL)
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    /**
     * 提供单例转换器
     *
     * @param gson
     * @return
     */
    @Singleton
    @Provides
    public Converter.Factory provideConverter(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    /**
     * 提供单例Gson
     *
     * @return
     */
    @Singleton
    @Provides
    public Gson provideGson() {
        return new GsonBuilder()
                .serializeNulls()
                .create();
    }

    /**
     * 提供单例OkHttpClient
     *
     * @param interceptor
     * @return
     */
    @Singleton
    @Provides
    public OkHttpClient provideClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

    /**
     * 提供单例日志拦截器
     *
     * @return
     */
    @Singleton
    @Provides
    public HttpLoggingInterceptor provideInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE);
    }
}
