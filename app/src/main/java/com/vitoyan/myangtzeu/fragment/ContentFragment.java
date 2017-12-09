package com.vitoyan.myangtzeu.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;

import com.vitoyan.myangtzeu.R;
import com.vitoyan.myangtzeu.base.BaseFragment;
import com.vitoyan.myangtzeu.utils.LogUtil;

/**
 * 作者：Vito-Yan
 * 作用：正文Fragment
 */
public class ContentFragment extends BaseFragment {

    private ViewPager viewpager;
    private RadioGroup rg_main;

    @Override
    public View initView() {
        LogUtil.e("正文视图被初始化了");
        View view = View.inflate(context, R.layout.content_fragment,null);
        viewpager = view.findViewById(R.id.viewpager);
        rg_main = view.findViewById(R.id.rg_main);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("正文数据被初始化了");

        //设置默认选中首页
        rg_main.check(R.id.rb_home);
    }

}
