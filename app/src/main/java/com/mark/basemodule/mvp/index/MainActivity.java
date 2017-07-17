package com.mark.basemodule.mvp.index;

import android.content.Intent;
import android.widget.Button;

import com.mark.basemodule.R;
import com.mark.basemodule.mvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<IndexContant.IndexPresenter> implements IndexContant.IndexView {

    @BindView(R.id.btn_index)
    Button mBtnIndex;

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


    @OnClick(R.id.btn_index)
    public void onViewClicked() {
        mPresenter.loadIndex("35");
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public Button getButton() {
        return mBtnIndex;
    }
}
