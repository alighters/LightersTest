package com.lighters.demo.leak;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.lighters.demo.R;
import com.lighters.demo.app.BaseActivity;

import java.lang.ref.WeakReference;

/**
 * Created by david on 15/12/18.
 */
public class HandlerActivity extends BaseActivity {

    /** 错误的写法 **/
    private final Handler mLeakyHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // ...
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.leak_handler);
        // Post a message and delay its execution for 10 minutes.
        mLeakyHandler.postDelayed(new Runnable() {
            @Override
            public void run() { /* ... */ }
        }, 1000 * 60 * 10);

    }


    /** 正确地写法 **/

    /**
     * Instances of static inner classes do not hold an implicit
     * reference to their outer class.
     */
    private static class MyHandler extends Handler {
        private final WeakReference<HandlerActivity> mActivity;

        public MyHandler(HandlerActivity activity) {
            mActivity = new WeakReference<HandlerActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            HandlerActivity activity = mActivity.get();
            if (activity != null) {
                // ...
            }
        }
    }

    private final MyHandler mHandler = new MyHandler(this);

    /**
     * Instances of anonymous classes do not hold an implicit
     * reference to their outer class when they are "static".
     */
    private static final Runnable sRunnable = new Runnable() {
        @Override
        public void run() { /* ... */ }
    };

}
