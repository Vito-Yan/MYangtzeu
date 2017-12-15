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
 * 作用：ES 6页面
 */
public class News1MenuDetailPager extends MenuDetaiBasePager {

    private TextView textView;

    public News1MenuDetailPager(Context context) {
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
        
        LogUtil.e("ES 6页面数据被初始化了..");
        textView.setText("ES 6页面内容");



    }
}
