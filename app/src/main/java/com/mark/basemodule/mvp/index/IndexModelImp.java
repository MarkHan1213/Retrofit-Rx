package com.mark.basemodule.mvp.index;

import com.mark.basemodule.base.net.ErrorUnStandardCheckerTransformer;
import com.mark.basemodule.base.net.RxSchedulersCompat;
import com.mark.basemodule.mvp.base.BaseModelImp;
import com.mark.basemodule.mvp.bean.IndexData;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Mark.Han on 2017/7/11.
 */

public class IndexModelImp extends BaseModelImp<IndexService> implements IndexContant.IndexModel {

    protected IndexModelImp(Class<IndexService> clazz) {
        super(clazz);
    }

    @Override
    public Observable<IndexData.LiveCourseBean> getDetail(String id) {
        return mService.getDedail(id)
                .compose(new ErrorUnStandardCheckerTransformer<IndexData>())
                .map(new Function<IndexData, IndexData.LiveCourseBean>() {
                    @Override
                    public IndexData.LiveCourseBean apply(IndexData indexData) throws Exception {
                        return indexData.getLiveCourse();
                    }
                })
                .compose(RxSchedulersCompat.<IndexData.LiveCourseBean>applyIoSchedulers());
    }
}
