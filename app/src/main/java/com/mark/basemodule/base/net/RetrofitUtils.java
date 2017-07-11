package com.mark.basemodule.base.net;


import com.mark.basemodule.BuildConfig;
import com.mark.basemodule.base.BaseApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;
import static okhttp3.logging.HttpLoggingInterceptor.Level.NONE;

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
        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? BODY : NONE);

        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new CacheInterceptor())
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
            Response response = chain.proceed(request);
            Response response1 = response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    //cache for 30 days
                    .header("Cache-Control", "max-age=" + 3600 * 24)
                    .build();
            return response1;
        }
    }

}



