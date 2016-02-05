package com.lighters.demo.activity;

import android.app.Service;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.lighters.demo.R;
import com.lighters.demo.app.BaseActivity;
import com.lighters.demo.keyboard.SoftKeyboard;
import com.orhanobut.logger.Logger;

/**
 * Created by david on 16/1/26.
 */
public class KeyboardActivity extends BaseActivity {

    /*
       * Instantiate and pass a callback
       */
    SoftKeyboard softKeyboard;

    private Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_keyboard);

        setKeyboardEvent();

        setListenerToRootView();

        mHandler = new Handler();
    }

    /**
     * 1. adjustPan 当光标被遮挡之后, 键盘才会进行弹起
     * 2. adjustResize 任何控件获取光标之后, 键盘都会弹起
     * 3. adjustNothing 键盘始终不会弹起
     *
     * @param newConfig
     */

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


        // Checks whether a hardware keyboard is available
//        if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
//            Toast.makeText(this, "keyboard visible", Toast.LENGTH_SHORT).show();
//        } else if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES) {
//            Toast.makeText(this, "keyboard hidden", Toast.LENGTH_SHORT).show();
//        }
    }

    boolean isOpened = false;

    public void setListenerToRootView() {
//        final View activityRootView = getWindow().getDecorView().findViewById(android.R.id.content);
//        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver
// .OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//
//                int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();
//                if (heightDiff > 100) { // 99% of the time the height diff will be due to a keyboard.
//                    Toast.makeText(getApplicationContext(), "Gotcha!!! softKeyboardup", Toast.LENGTH_SHORT).show();
//
//                    if (isOpened == false) {
//                        //Do two things, make the view top visible and the editText smaller
//                    }
//                    isOpened = true;
//                } else if (isOpened == true) {
//                    Toast.makeText(getApplicationContext(), "softkeyborad Down!!!", Toast.LENGTH_SHORT).show();
//                    isOpened = false;
//                }
//            }
//        });
    }

    private void setKeyboardEvent() {
        final RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.main_layout); // You must use the layout
        // root
        InputMethodManager im = (InputMethodManager) getSystemService(Service.INPUT_METHOD_SERVICE);


        softKeyboard = new SoftKeyboard(mainLayout, im);
        softKeyboard.setSoftKeyboardCallback(new SoftKeyboard.SoftKeyboardChanged() {

            @Override
            public void onSoftKeyboardHide() {
                // Code here
                Logger.d("keyboard_hide");
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mainLayout.getLayoutParams();
                        params.bottomMargin = 0;
                        mainLayout.setLayoutParams(params);
                    }
                });
            }

            @Override
            public void onSoftKeyboardShow() {
                // Code here
                Logger.d("keyboard_show");
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mainLayout.getLayoutParams();
                        params.bottomMargin = 100;
                        mainLayout.setLayoutParams(params);
                    }
                });


            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        softKeyboard.unRegisterSoftKeyboardCallback();
    }
}
