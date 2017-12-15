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
 * 作用：Java页面
 */
public class News3MenuDetailPager extends MenuDetaiBasePager {

    private TextView textView;

    public News3MenuDetailPager(Context context) {
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

        LogUtil.e("Java页面数据被初始化了..");
        textView.setText("Java页面内容");



    }
}
