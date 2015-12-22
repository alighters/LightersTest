package com.lighters.demo.leak.task;

import com.lighters.demo.leak.callback.CallBack;
import com.orhanobut.logger.Logger;

import java.lang.ref.WeakReference;

/**
 * Created by david on 15/12/17.
 */
public class WeakTask {

    public void excute(CallBack callback) {
        new WeakThread(callback).start();
    }

    private static class WeakThread extends Thread {
        public WeakThread(CallBack callback) {
            this.call = new WeakReference<>(callback);
        }


        private WeakReference<CallBack> call;


        @Override
        public void run() {
            super.run();
            try {
                int i = 0;
                if (call.get() != null) {
                    call.get().onStart(i + "");
                }
                while (true) {
                    Thread.sleep(1000);

                    if (call.get() != null) {
                        call.get().onExcute(i + "");
                    } else {
                        Logger.d("Thread内部:" + i);
                    }
                    i++;

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
