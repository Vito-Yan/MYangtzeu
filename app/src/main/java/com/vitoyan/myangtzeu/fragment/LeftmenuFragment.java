package com.vitoyan.myangtzeu.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.vitoyan.myangtzeu.base.BaseFragment;
import com.vitoyan.myangtzeu.utils.LogUtil;

/**
 * 作者：Vito-Yan
 * 作用：左侧菜单的Fragment
 */

public class LeftmenuFragment extends BaseFragment {

    private TextView textView;


    @Override
    public View initView() {
        LogUtil.e("左侧菜单视图被初始化了");
        textView = new TextView(context);
        textView.setTextSize(23);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.WHITE);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("左侧菜单数据被初始化了");
        textView.setText("左侧菜单页面");
    }
}
