package com.vitoyan.myangtzeu.menudatailpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TabPageIndicator;
import com.vitoyan.myangtzeu.R;
import com.vitoyan.myangtzeu.base.MenuDetaiBasePager;
import com.vitoyan.myangtzeu.menudatailpager.tabdetailpager.TabDetailPager;
import com.vitoyan.myangtzeu.pojo.HomePagerBean;
import com.vitoyan.myangtzeu.utils.LogUtil;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Vito-Yan
 * 作用：React Native页面
 */
public class NewsMenuDetailPager extends MenuDetaiBasePager {

    @ViewInject(R.id.tabPageIndicator)
    private TabPageIndicator tabPageIndicator;

    @ViewInject(R.id.viewpager)
    private ViewPager viewPager;


    /**
     * 页签页面的数据的集合-数据
     */
    private List<HomePagerBean.DetailPagerData.ChildrenData> children;
    /**
     * 页签页面的集合-页面
     */
    private ArrayList<TabDetailPager> tabDetailPagers;



    public NewsMenuDetailPager(Context context, HomePagerBean.DetailPagerData detailPagerData) {
        super(context);
        children = detailPagerData.getChildren();
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.newsmenu_detail_pager,null);
        x.view().inject(NewsMenuDetailPager.this,view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();

        LogUtil.e("React Native页面数据被初始化了..");
        //准备新闻详情页面的数据
        tabDetailPagers = new ArrayList<>();
        for(int i=0;i<children.size();i++){
            tabDetailPagers.add(new TabDetailPager(context,children.get(i)));
        }
        //设置ViewPager的适配器
        viewPager.setAdapter(new MyNewsMenuDetailPagerAdapter());
        //ViewPager和TabPageIndicator关联
        tabPageIndicator.setViewPager(viewPager);

    }

    class MyNewsMenuDetailPagerAdapter extends PagerAdapter {

        @Override
        public CharSequence getPageTitle(int position) {
            return children.get(position).getTitle();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TabDetailPager tabDetailPager  =tabDetailPagers.get(position);
            View rootView = tabDetailPager.rootView;
            tabDetailPager.initData();//初始化数据
            container.addView(rootView);
            return rootView;
        }

        @Override
        public int getCount() {
            return tabDetailPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }

}
