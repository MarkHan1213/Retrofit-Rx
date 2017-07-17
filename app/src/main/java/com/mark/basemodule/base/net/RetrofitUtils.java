package com.mark.basemodule.base.net;


import com.mark.basemodule.mvp.base.BaseApplication;
import com.mark.basemodule.utils.NetworkUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

/**
 * Created by Mark.Han on 2017/7/6.
 */

public class RetrofitUtils {

    //单位秒，读，写，链接时长
    private static final long DEFAULT_READ_TIMEOUT_MILLIS = 15;
    private static final long DEFAULT_WRITE_TIMEOUT_MILLIS = 20;
    private static final long DEFAULT_CONNECT_TIMEOUT_MILLIS = 20;


    private static class RetrofitHolder {

        private static Retrofit INSTANCE = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(initHttpClient())
                .addConverterFactory(StringConverterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 初始化OkHttpClient
     *
     * @return 配置好的OKHttpClient
     */
    private static OkHttpClient initHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        // 开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等
//        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? BODY : NONE);
        httpLoggingInterceptor.setLevel(BODY);

        return new OkHttpClient.Builder()
//                .addNetworkInterceptor(new CacheInterceptor())
                .addInterceptor(new CacheInterceptor())
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLIS, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_WRITE_TIMEOUT_MILLIS, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .cache(new Cache(BaseApplication.getInstance().getCacheDir(), 1024 * 1024 * 10))
                .build();
    }


    public static <T> T createService(Class<T> serviceClazz) {
        return RetrofitHolder.INSTANCE.create(serviceClazz);
    }


    static class CacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetworkUtil.isNetworkReachable(BaseApplication.getInstance().getApplicationContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)//无网络时只从缓存中读取
                        .build();
            }

            Response response = chain.proceed(request);

            if (NetworkUtil.isNetworkReachable(BaseApplication.getInstance().getApplicationContext())) {
                int maxAge = 60; // 有网络时 设置缓存超时时间1分钟
                response.newBuilder()
                        .removeHeader("Pragma")
                        //清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .header("Cache-Control", "public, max-age=" + maxAge)//设置缓存超时时间
                        .build();
            } else {
                int maxStale = 3600 * 24; // 无网络时，设置超时为1天
                response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        //设置缓存策略，及超时策略
                        .build();
            }

//            if (!StringsUtil.isNetworkReachable(App.app)) {
//                request = request.newBuilder()
//                        .cacheControl(CacheControl.FORCE_CACHE)
//                        .build();
//                LogCat.i("no network");
//            }
            return response;
//            response.newBuilder()
//                    .removeHeader("Pragma")
//                    .removeHeader("Cache-Control")
//                    .header("Cache-Control", "max-age=" + 3600 * 24)
//                    .build();
        }
    }

}



