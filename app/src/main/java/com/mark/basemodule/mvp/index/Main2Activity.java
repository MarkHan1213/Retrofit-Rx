package com.mark.basemodule.mvp.index;

import android.os.Bundle;
import android.widget.Button;

import com.mark.basemodule.R;
import com.mark.basemodule.mvp.base.BaseActivity;

public class Main2Activity extends BaseActivity<IndexContant.IndexPresenter> implements IndexContant.IndexView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected IndexContant.IndexPresenter getPresenter() {
        return new IndexPresenterImp();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected void onDestroy() {
        try {
            mPresenter.loadIndex("33");
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    @Override
    public Button getButton() {
        return null;
    }
}
