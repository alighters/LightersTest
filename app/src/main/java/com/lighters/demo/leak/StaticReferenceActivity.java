package com.lighters.demo.leak;

import android.content.Context;
import android.os.Bundle;

import com.lighters.demo.R;
import com.lighters.demo.app.BaseActivity;

/**
 * Created by david on 15/12/18.
 * <p/>
 * 当前实例被静态引用持有, 引起的内存泄露
 */
public class StaticReferenceActivity extends BaseActivity {

    private static Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.leak_static_reference);
        mContext = this;
    }
}
