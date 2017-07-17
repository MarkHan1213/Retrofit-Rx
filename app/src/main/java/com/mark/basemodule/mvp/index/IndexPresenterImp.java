package com.mark.basemodule.mvp.index;

import android.content.Context;
import android.util.Log;

import com.mark.basemodule.base.net.ErrorHandleSubscriber;
import com.mark.basemodule.mvp.base.BasePresenterImp;
import com.mark.basemodule.mvp.bean.IndexData;

/**
 * Created by Mark.Han on 2017/7/11.
 */

public class IndexPresenterImp extends BasePresenterImp<IndexContant.IndexView, IndexModelImp> implements IndexContant.IndexPresenter {

    @Override
    protected IndexModelImp getModel() {
        return new IndexModelImp(IndexService.class);
    }

    @Override
    public void loadIndex(final String id) {
        Log.e("--Main--", "loadIndex: ");
//        mModel.getDedail("59").subscribe(new Observer<IndexData.LiveCourseBean>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.e("--Main--", "onSubscribe: ");
//            }
//
//            @Override
//            public void onNext(IndexData.LiveCourseBean liveCourseBean) {
//                Log.e("--Main--", "liveCourseBean: " + liveCourseBean.toString());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e("--Main--", "e: " + e.getLocalizedMessage());
//            }
//
//            @Override
//            public void onComplete() {
//                Log.e("--Main--", "onComplete: ");
//            }
//        });
        mModel.getDetail(id).subscribe(new ErrorHandleSubscriber<IndexData.LiveCourseBean>((Context) getView()) {
            @Override
            public void onNext(IndexData.LiveCourseBean liveCourseBean) {
                Log.e("--Main--", "onNext: " + id + liveCourseBean.toString());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
