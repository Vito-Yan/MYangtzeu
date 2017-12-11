package com.vitoyan.myangtzeu.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.vitoyan.myangtzeu.base.BasePager;
import com.vitoyan.myangtzeu.utils.LogUtil;



/**
 * 作者：Vito-Yan
 * 作用：首页页面
 */
public class HomePager extends BasePager {
    public HomePager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("首页页面数据被初始化了..");
        ib_menu.setVisibility(View.VISIBLE);
        //1.设置标题
        tv_title.setText("资讯");
        //2.联网请求，得到数据，创建视图
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(25);
        //3.把子视图添加到BasePager的FrameLayout中
        fl_content.addView(textView);
        //4.绑定数据
        textView.setText("首页页面内容");

    }
}
