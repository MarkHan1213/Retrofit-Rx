package com.mark.basemodule.base.net;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import retrofit2.Response;

/**
 * Created on 2017/2/28.
 * Desc：非标准格式请求
 * Author：Eric.w
 */
public class ErrorUnStandardCheckerTransformer<T> implements ObservableTransformer<Response<T>, T> {

    @Override
    public ObservableSource<T> apply(Observable<Response<T>> upstream) {
        return upstream.map(new Function<Response<T>, T>() {
            @Override
            public T apply(Response<T> tResponse) throws Exception {
                String errorMsg = null;
                //响应头不为200，或者响应体为null，则抛出异常
                if (tResponse.code() != 200) {
                    try {
                        errorMsg = tResponse.errorBody().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    //数据为空，提前处理
                    if (tResponse.body() == null)
                        errorMsg = "请求数据为空！";
                }
                if (errorMsg != null) {
                    try {
                        throw new ErrorResponseException(errorMsg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return tResponse.body();
            }
        });
    }
}
