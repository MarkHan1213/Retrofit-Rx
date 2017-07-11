package com.mark.basemodule.mvp.index;

import com.mark.basemodule.mvp.base.BaseContant;
import com.mark.basemodule.mvp.bean.IndexData;

import io.reactivex.Observable;

/**
 * Created by Mark.Han on 2017/7/11.
 */

public class IndexContant {
    public interface IndexView extends BaseContant.BaseView {
        void loadIndex();
    }

    public interface IndexPresenter extends BaseContant.BasePresenter<IndexView> {
        void loadIndex();
    }

    public interface IndexModel extends BaseContant.BaseModel {
        Observable<IndexData> getIndex();
    }
}
