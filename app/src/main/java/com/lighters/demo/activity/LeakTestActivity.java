package com.lighters.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lighters.demo.R;
import com.lighters.demo.app.BaseActivity;
import com.lighters.demo.leak.HandlerActivity;
import com.lighters.demo.leak.StaticReferenceActivity;
import com.lighters.demo.leak.ThreadActivity;
import com.lighters.demo.leak.WeakCallbackActivity;

public class LeakTestActivity extends BaseActivity {

    private Button mBtnThread;
    private Button mBtnWeakCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_test);
        initView();
    }

    private void initView() {
        mBtnThread = (Button) findViewById(R.id.btn_thread);
        mBtnThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LeakTestActivity.this, ThreadActivity.class));
            }


        });

        mBtnWeakCallback = (Button) findViewById(R.id.btn_weak_callback);
        mBtnWeakCallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LeakTestActivity.this, WeakCallbackActivity.class));
            }
        });

        findViewById(R.id.btn_static_reference).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LeakTestActivity.this, StaticReferenceActivity.class));
            }
        });
        findViewById(R.id.btn_handler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LeakTestActivity.this, HandlerActivity.class));
            }
        });

    }


}
