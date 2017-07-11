package com.mark.basemodule.base.net;

import com.mark.basemodule.base.BaseResponse;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import retrofit2.Response;

/**
 * Created on 2017/2/28.
 * Desc：标准格式处理请求
 * Author：Eric.w
 */
public class ErrorStandardCheckerTransformer<T> implements ObservableTransformer<Response<BaseResponse<T>>, T> {

    @Override
    public ObservableSource<T> apply(Observable<Response<BaseResponse<T>>> upstream) {
        return upstream.map(new Function<Response<BaseResponse<T>>, T>() {
            @Override
            public T apply(Response<BaseResponse<T>> baseResultResponse) throws Exception {
                String errorMsg = null;
                //响应头不为200，或者响应体为null，则抛出异常
                if (baseResultResponse.code() != 200) {
                    try {
                        errorMsg = baseResultResponse.errorBody().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (baseResultResponse.body() == null) {
                        errorMsg = "请求数据为空！";
                        //服务器 返回数据不为0，则数据请求出错
                    } else {
                        if (baseResultResponse.body().getStatus() != BaseResponse.CODE_SUCCESS) {
                            errorMsg = baseResultResponse.body().getMsg();
                            //返回的数据体为null,统一处理
                        } else if (baseResultResponse.body().getData() == null) {
                            errorMsg = "Responce is null";
                        }
                    }
                }
                if (errorMsg != null) {
                    try {
                        throw new ErrorResponseException(errorMsg);
                    } catch (ErrorResponseException e) {
                        throw Exceptions.propagate(e);
                    }
                }
                return baseResultResponse.body().getData();
            }
        });
    }
}
