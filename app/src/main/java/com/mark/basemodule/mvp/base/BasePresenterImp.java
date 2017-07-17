package com.mark.basemodule.mvp.base;

import com.mark.basemodule.base.net.RxDisposableManager;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Mark.Han on 2017/7/13.
 */

public abstract class BasePresenterImp<T extends BaseView, M extends BaseModelImp> {
    private WeakReference mView;
    protected M mModel;
    protected CompositeDisposable compositeDisposable;

    public void attach(T view) {
        if (mView == null) {
            mView = new WeakReference(view);
        }
        if (getModel() != null) {
            mModel = getModel();
        }
        compositeDisposable = new CompositeDisposable();
    }

    protected abstract M getModel();

    public void detach() {
        if (mView != null) {
            RxDisposableManager.get().cancel(mView.get());
            mView.clear();
            mView = null;
        }
        // TODO: 2017/7/13 资源回收
        mModel.onDetach();
    }

    public T getView() {
        if (mView != null) {
            return (T) mView.get();
        }
        return null;
    }
}
