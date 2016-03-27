package com.team.baseapp.baseapp.api;

import com.team.baseapp.baseapp.BuildConfig;

import java.util.concurrent.TimeUnit;

//import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * retrofit builder请求网络
 * 通过静态内部类方式实现单例
 * Created by lynnzc on 16-3-20.
 */
public class ApiModule {
    public static final String BASE_URL = BuildConfig.SERVICE_API_URL;

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;

    private ApiModule() {
//        OkHttpClient.Builder client = new OkHttpClient.Builder();
//        client.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        //TODO Interceptor增加

        retrofit = new Retrofit
                .Builder()
//                .client(client.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    /**
     * 静态内部类 持有Api单例
     */
    private static class SingleTonHolder {
        private static final ApiModule INSTANCE = new ApiModule();
    }

    /**
     * 获取ApiModule实例
     *
     * @return
     */
    public static ApiModule api() {
        return SingleTonHolder.INSTANCE;
    }
}
