package com.lighters.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lighters.demo.R;
import com.lighters.demo.app.BaseActivity;

public class MainActivity extends BaseActivity {

    private Button mBtnLeakTest;
    private Button mBtnKeyboardTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        mBtnLeakTest = (Button) findViewById(R.id.btn_leak_test);
        mBtnLeakTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KeyboardActivity.class));
            }


        });

        mBtnKeyboardTest = (Button) findViewById(R.id.btn_keyboard_test);
        mBtnKeyboardTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KeyboardActivity.class));
            }
        });


    }


}
