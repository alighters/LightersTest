package com.lighters.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lighters.demo.app.BaseActivity;
import com.lighters.demo.leak.ThreadActivity;
import com.lighters.demo.leak.WeakCallbackActivity;

public class MainActivity extends BaseActivity {

    private Button mBtnThread;
    private Button mBtnWeakCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnThread = (Button) findViewById(R.id.btn_thread);
        mBtnThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ThreadActivity.class));
            }


        });

        mBtnWeakCallback = (Button) findViewById(R.id.btn_weak_callback);
        mBtnWeakCallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WeakCallbackActivity.class));
            }
        });
    }


}
