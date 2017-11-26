package com.vitoyan.myangtzeu.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.vitoyan.myangtzeu.base.BaseFragment;
import com.vitoyan.myangtzeu.utils.LogUtil;

/**
 * 作者：Vito-Yan
 * 作用：正文Fragment
 */
public class ContentFragment extends BaseFragment {

    private TextView textView;

    @Override
    public View initView() {
        LogUtil.e("正文视图被初始化了");
        textView = new TextView(context);
        textView.setTextSize(23);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLACK);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("正文数据被初始化了");
        textView.setText("正文页面");
    }

}
