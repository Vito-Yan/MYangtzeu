package com.vitoyan.myangtzeu.menudatailpager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.vitoyan.myangtzeu.base.MenuDetaiBasePager;
import com.vitoyan.myangtzeu.utils.LogUtil;


/**
 * 作者：Vito-Yan
 * 作用：Android页面
 */
public class News4MenuDetailPager extends MenuDetaiBasePager {

    private TextView textView;

    public News4MenuDetailPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {

        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(25);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();

        LogUtil.e("Android页面数据被初始化了..");
        textView.setText("Android页面内容");



    }
}
