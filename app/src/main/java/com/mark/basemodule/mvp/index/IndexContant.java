package com.mark.basemodule.mvp.index;

import android.widget.Button;

import com.mark.basemodule.mvp.base.BasePresenter;
import com.mark.basemodule.mvp.base.BaseView;
import com.mark.basemodule.mvp.bean.IndexData;

import io.reactivex.Observable;

/**
 * Created by Mark.Han on 2017/7/11.
 */

public interface IndexContant {
    interface IndexView extends BaseView {
        Button getButton();
    }

    interface IndexPresenter extends BasePresenter<IndexView> {
        void loadIndex(String id);
    }

    interface IndexModel {
        Observable<IndexData.LiveCourseBean> getDetail(String id);
    }
}
