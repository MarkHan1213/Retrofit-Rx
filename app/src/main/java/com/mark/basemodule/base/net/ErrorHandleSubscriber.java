package com.mark.basemodule.base.net;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created on 2017/3/1.
 * Desc：处理异常的Observer
 * Author：Eric.w
 */

public abstract class ErrorHandleSubscriber<T> implements Observer<T> {

    protected WeakReference<Context> mContext;
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ErrorHandleSubscriber(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    @Override
    public void onSubscribe(Disposable d) {
        compositeDisposable.add(d);
    }

    @Override
    public void onError(Throwable e) {
        Context context = mContext.get();
        if (context == null) return;
        if (e instanceof SocketTimeoutException) {
            Toast.makeText(context, "请求超时！", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(context, "网络中断，请检查您的网络状态！", Toast.LENGTH_SHORT).show();
        } else if (e instanceof UnknownHostException) {
            Toast.makeText(context, "网络错误，请检查您的网络状态！", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("rxjava", "error----------->" + e.toString());
        }
    }
}
