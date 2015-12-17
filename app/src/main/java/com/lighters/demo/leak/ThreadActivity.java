package com.lighters.demo.leak;

import android.app.Activity;
import android.os.Bundle;

import com.lighters.demo.app.BaseActivity;
import com.orhanobut.logger.Logger;

/**
 * Created by david on 15/12/17.
 *
 * 耗时匿名内部类, 持有外部类引用, 导致外部类不能释放, 最后的结果内存泄露
 */
public class ThreadActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showThreadInfo();
    }

    int i = 0;
    private void showThreadInfo(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        Thread.sleep(1000);
                        Logger.d(i++ + "");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
