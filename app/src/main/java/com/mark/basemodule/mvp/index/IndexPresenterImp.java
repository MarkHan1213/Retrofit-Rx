package com.mark.basemodule.mvp.index;

/**
 * Created by Mark.Han on 2017/7/11.
 */

public class IndexPresenterImp implements IndexContant.IndexPresenter {

    private IndexContant.IndexView mView;


    @Override
    public void attach(IndexContant.IndexView view) {
        mView = view;
    }


    @Override
    public void dettach() {
        if (mView != null){
            mView = null;
        }
    }

    @Override
    public void loadIndex() {

    }
}
