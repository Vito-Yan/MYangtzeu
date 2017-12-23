package com.vitoyan.myangtzeu.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.facebook.react.ReactActivity;

/**
 * 作者：Vito-Yan
 * 作用：发现页面
 */
public class FindActivity extends ReactActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideBottomUIMenu();
        super.onCreate(savedInstanceState);
    }


    @Override
    protected String getMainComponentName() {
        return "FindPager";//这个在Registry.registerComponent注册
    }

    /**
     * 隐藏虚拟按键，并且全屏
     */
    protected void hideBottomUIMenu() {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }
}
