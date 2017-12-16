package com.vitoyan.myangtzeu.menudatailpager.tabdetailpager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.vitoyan.myangtzeu.base.MenuDetaiBasePager;
import com.vitoyan.myangtzeu.pojo.HomePagerBean;
import com.vitoyan.myangtzeu.utils.LogUtil;


/**
 * 作者：Vito-Yan
 * 作用：ES 6页面
 */
public class TabDetailPager extends MenuDetaiBasePager {

    private TextView textView;

    private final HomePagerBean.DetailPagerData.ChildrenData childrenData;

    public TabDetailPager(Context context, HomePagerBean.DetailPagerData.ChildrenData childrenData) {
        super(context);
        this.childrenData = childrenData;
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
        textView.setText(childrenData.getTitle());



    }
}
