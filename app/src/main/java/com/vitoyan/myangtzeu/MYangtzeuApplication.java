package com.vitoyan.myangtzeu;

import android.app.Application;

import org.xutils.x;


/**
 * 作者：Vito-Yan
 * 作用：代表整个软件
 */
public class MYangtzeuApplication extends Application {
    /**
    所有组件被创建之前执行
     */
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.setDebug(true);
        x.Ext.init(this);
    }

}
