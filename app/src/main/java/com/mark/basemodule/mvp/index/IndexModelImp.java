package com.mark.basemodule.mvp.index;

import com.mark.basemodule.mvp.base.BaseModelImp;
import com.mark.basemodule.mvp.bean.IndexData;
import com.mark.basemodule.base.net.ErrorStandardCheckerTransformer;

import io.reactivex.Observable;

/**
 * Created by Mark.Han on 2017/7/11.
 */

public class IndexModelImp extends BaseModelImp<IndexService> implements IndexContant.IndexModel {

    protected IndexModelImp(Class<IndexService> clazz) {
        super(clazz);
    }

    @Override
    public Observable<IndexData> getIndex() {
        return mService.getIndex().compose(new ErrorStandardCheckerTransformer<IndexData>());
    }
}
