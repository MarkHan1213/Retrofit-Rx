package com.mark.basemodule.base.net;

import android.util.Log;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * Created by Mark.Han on 2017/7/13.
 */

public class RxDisposableManager {

    private static RxDisposableManager sManager;

//        private CompositeDisposable compositeDisposable;
    private HashMap<String, Disposable> mHashMap;

    private RxDisposableManager() {
//        compositeDisposable = new CompositeDisposable();
        mHashMap = new HashMap<>();
    }

    public static RxDisposableManager get() {
        if (sManager == null) {
            synchronized (RxDisposableManager.class) {
                if (sManager == null) {
                    sManager = new RxDisposableManager();
                }
            }
        }
        return sManager;
    }


    /**
     * 添加到订阅
     *
     * @param o
     * @param disposable
     */
    public void add(Object o, Disposable disposable) {
        Log.e("--Main--", "订阅了: " + o.getClass().getSimpleName() + disposable.hashCode());
        mHashMap.put(o.getClass().getSimpleName() + disposable.hashCode(), disposable);
//        compositeDisposable.add(disposable);
    }

    /**
     * 取消当前全部订阅
     *
     * @param o
     */
    public void cancel(final Object o) {
//        compositeDisposable.clear();
        Log.e("--Main--", "删除了: " + o.getClass().getSimpleName());
        if (!mHashMap.isEmpty()) {
            Observable.fromIterable(new CopyOnWriteArraySet<>(mHashMap.keySet()))
                    .filter(new Predicate<String>() {
                        @Override
                        public boolean test(String s) throws Exception {
                            Log.e("--Main--", "test: " + s.contains(o.getClass().getSimpleName()));
                            return s.contains(o.getClass().getSimpleName());
                        }
                    })
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            cancelDisposableByTag(s);
                        }
                    });
        }
    }

    private void cancelDisposableByTag(String tag) {
        Disposable disposable = mHashMap.get(tag);
        if (disposable != null) {
            mHashMap.remove(tag);
            disposable.dispose();
        }

    }

}
