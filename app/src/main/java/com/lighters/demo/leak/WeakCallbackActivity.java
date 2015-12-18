package com.lighters.demo.leak;

import android.os.Bundle;

import com.lighters.demo.R;
import com.lighters.demo.app.BaseActivity;
import com.lighters.demo.leak.callback.WeakCallback;
import com.lighters.demo.leak.task.WeakTask;
import com.orhanobut.logger.Logger;

/**
 * Created by david on 15/12/17.
 */
public class WeakCallbackActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.leak_weak_callback);
        execute();
    }

    private void execute() {
        Logger.d("execute");
        new WeakTask().excute(new WeakCallback() {

            @Override
            public void onStart(String msg) {
                Logger.d(msg);
            }

            @Override
            public void onExcute(String msg) {
                Logger.d(msg);
            }

            @Override
            public void onSucces(String msg) {
                Logger.d(msg);
            }
        });
    }
}
