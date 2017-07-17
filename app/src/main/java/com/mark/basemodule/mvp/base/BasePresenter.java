package com.mark.basemodule.mvp.base;

/**
 * Created by Mark.Han on 2017/7/13.
 */

public interface BasePresenter<T extends BaseView> {
    void attach(T view);

    void detach();

    T getView();
}
