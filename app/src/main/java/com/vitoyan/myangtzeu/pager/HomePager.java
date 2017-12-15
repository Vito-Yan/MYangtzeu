package com.vitoyan.myangtzeu.pager;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.vitoyan.myangtzeu.activity.MainActivity;
import com.vitoyan.myangtzeu.base.BasePager;
import com.vitoyan.myangtzeu.base.MenuDetaiBasePager;
import com.vitoyan.myangtzeu.fragment.LeftmenuFragment;
import com.vitoyan.myangtzeu.menudatailpager.News1MenuDetailPager;
import com.vitoyan.myangtzeu.menudatailpager.News2MenuDetailPager;
import com.vitoyan.myangtzeu.menudatailpager.News3MenuDetailPager;
import com.vitoyan.myangtzeu.menudatailpager.News4MenuDetailPager;
import com.vitoyan.myangtzeu.menudatailpager.NewsMenuDetailPager;
import com.vitoyan.myangtzeu.pojo.HomePagerBean;
import com.vitoyan.myangtzeu.utils.CacheUtils;
import com.vitoyan.myangtzeu.utils.Constants;
import com.vitoyan.myangtzeu.utils.LogUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Vito-Yan
 * 作用：首页页面
 */
public class HomePager extends BasePager {

    /**
     * 左侧菜单对应的数据集合
     */
    private List<HomePagerBean.DataEntity> data;

    /**
     * 详情页面的集合
     */
    private ArrayList<MenuDetaiBasePager> detaiBasePagers;

    private long startTime;

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

        //得到缓存数据
        String saveJson = CacheUtils.getString(context,Constants.HOME_PAGER_URL);//""

        if(!TextUtils.isEmpty(saveJson)){
            processData(saveJson);
        }

        startTime = SystemClock.uptimeMillis();
        //联网请求数据
        getDataFromNet();
        //        getDataFromNetByVolley();

    }

    /**
     * 使用xUtils3联网请求数据
     */
    private void getDataFromNet() {

        RequestParams params = new RequestParams(Constants.HOME_PAGER_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                long endTime = SystemClock.uptimeMillis();
                long passTime = endTime - startTime;

                LogUtil.e("xUtils3--passTime==" + passTime);

                LogUtil.e("使用xUtils3联网请求成功==" + result);

                //缓存数据
                CacheUtils.putString(context,Constants.HOME_PAGER_URL,result);

                processData(result);
                //设置适配器


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e("使用xUtils3联网请求失败==" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                LogUtil.e("使用xUtils3-onCancelled==" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                LogUtil.e("使用xUtils3-onFinished");
            }
        });

    }

    /**
     * 解析json数据和显示数据
     *
     * @param json
     */
    private void processData(String json) {

        HomePagerBean bean = parsedJson(json);
//        HomePagerBean2 bean = parsedJson2(json);
//        String title = bean.getData().get(0).getChildren().get(1).getTitle();


//        LogUtil.e("使用Gson解析json数据成功-title==" + title);
        String title2 = bean.getData().get(0).getChildren().get(1).getTitle();
        LogUtil.e("使用Gson解析json数据成功HomePagerBean2-title2-------------------------==" + title2);
        //给左侧菜单传递数据
        data = bean.getData();

        MainActivity mainActivity = (MainActivity) context;
        //得到左侧菜单
        LeftmenuFragment leftmenuFragment = mainActivity.getLeftmenuFragment();

        //添加详情页面
        detaiBasePagers = new ArrayList<>();
        detaiBasePagers.add(new NewsMenuDetailPager(context));//新闻详情页面
        detaiBasePagers.add(new News1MenuDetailPager(context));//新闻1详情页面
        detaiBasePagers.add(new News2MenuDetailPager(context));//新闻2详情页面
        detaiBasePagers.add(new News3MenuDetailPager(context));//新闻3详情页面
        detaiBasePagers.add(new News4MenuDetailPager(context));//新闻4详情页面

        //把数据传递给左侧菜单
        leftmenuFragment.setData(data);


    }

    /**
     * 解析json数据：1,使用系统的API解析json；2,使用第三方框架解析json数据，例如Gson,fastjson
     *
     * @param json
     * @return
     */
    private HomePagerBean parsedJson(String json) {
        //        Gson gson = new Gson();
        //        HomePagerBean bean = gson.fromJson(json,HomePagerBean.class);
        return new Gson().fromJson(json, HomePagerBean.class);
    }

    /**
     * 根据位置切换详情页面
     *
     * @param position
     */
    public void swichPager(int position) {
        //1.设置标题
        tv_title.setText(data.get(position).getTitle());
        //2.移除之前内容
        fl_content.removeAllViews();//移除之前的视图

        //3.添加新内容
        MenuDetaiBasePager detaiBasePager = detaiBasePagers.get(position);//
        View rootView = detaiBasePager.rootView;
        detaiBasePager.initData();//初始化数据


        fl_content.addView(rootView);
    }


}
