package com.mark.basemodule.mvp.base;

import com.mark.basemodule.base.net.RetrofitUtils;

/**
 * Created by Mark.Han on 2017/7/11.
 */

public class BaseModelImp<T> implements BaseContant.BaseModel {

    protected T mService;

    protected BaseModelImp(Class<T> clazz) {
        mService = RetrofitUtils.createService(clazz);
    }
}
