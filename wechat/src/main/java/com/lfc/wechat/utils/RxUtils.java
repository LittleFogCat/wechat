package com.lfc.wechat.utils;

import rx.Observer;

/**
 * Created by LittleFogCat on 2017/8/31.
 */

public class RxUtils {
    public abstract static class DefaultObserver<T> implements Observer<T> {

        @Override
        public void onCompleted() {
            System.out.println("complete");
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }
}
