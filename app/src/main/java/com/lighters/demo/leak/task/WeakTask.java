package com.lighters.demo.leak.task;

import com.lighters.demo.leak.callback.WeakCallback;

import java.lang.ref.WeakReference;

/**
 * Created by david on 15/12/17.
 */
public class WeakTask {

    public WeakReference<WeakCallback> mCallbackWeakReference;

    int i = 0;

    public void excute(WeakCallback callback) {
        mCallbackWeakReference = new WeakReference<WeakCallback>(callback);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (mCallbackWeakReference.get() != null) {
                        mCallbackWeakReference.get().onStart(i + "");
                    }
                    while (true) {
                        Thread.sleep(1000);

                        if (mCallbackWeakReference.get() != null) {
                            mCallbackWeakReference.get().onExcute(i + "");
                        }
                        i++;

                        if (i >= 60) {
                            if (mCallbackWeakReference.get() != null) {
                                mCallbackWeakReference.get().onSucces(i + "");
                            }
                            return;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
