package com.mark.basemodule.mvp.base;

/**
 * Created by Mark.Han on 2017/7/11.
 */

public class BaseContant {

    public interface BaseView {
        void showLoading();

        void hideLoading();

    }

    public interface BasePresenter<T extends BaseView> {
        void attach(T view);

        void dettach();
    }

    public interface BaseModel {

    }
}
