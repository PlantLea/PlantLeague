package com.team.baseapp.baseapp.ui.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.entity.Good;
import com.team.baseapp.baseapp.entity.Image;
import com.team.baseapp.baseapp.entity.User;
import com.team.baseapp.baseapp.model.BannerModel;
import com.team.baseapp.baseapp.ui.adapter.HomeRecyclerAdapter;
import com.team.baseapp.baseapp.ui.base.BaseFragment;
import com.team.baseapp.baseapp.ui.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 主页 fragment
 * Created by lynnzc on 16-4-15.
 */
public class HomeFragment extends BaseFragment {
    private RecyclerView rv_home;
    private HomeRecyclerAdapter mAdapter;
    private int[] mTestResId = new int[]{
            R.drawable.ic_good1,
            R.drawable.ic_good2,
            R.drawable.ic_good3,
            R.drawable.ic_good4,
            R.drawable.ic_good5,
            R.drawable.ic_good6,
            R.drawable.ic_good7,
            R.drawable.ic_good8,
    };
    List<Object> datas;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View root) {
        initHomeRecyclerView(root);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        initHomeData();
        mAdapter = new HomeRecyclerAdapter(getContext(), datas);
        rv_home.setAdapter(mAdapter);
    }

    @Override
    protected void initHeaderView(@NonNull View header) {
        TextView tv_title = (TextView) header.findViewById(R.id.tv_title);
        tv_title.setText("首页");
    }

    @Override
    public int getHeaderRes() {
        return R.layout.include_header;
    }

    /**
     * 初始化 home布局
     *
     * @param root
     */
    private void initHomeRecyclerView(View root) {
        rv_home = (RecyclerView) root.findViewById(R.id.rv_home);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        rv_home.setLayoutManager(layoutManager);
    }

    /**
     * 初始化首页数据
     */
    private void initHomeData() {
        datas = new ArrayList<>();
        //头部轮播
        BannerModel bannerModel = new BannerModel();
        datas.add(bannerModel);
        //推荐的商品
        for (int i = 0; i < 8; i++) {
            datas.add(getGood(i));
        }
    }

    /**
     * 返回测试用的商品数据
     *
     * @param i
     * @return
     */
    private Good getGood(int i) {
        Good good = new Good();
        good.setName("剁手推荐" + i + "号");
        good.setPrice(i * 100);
        good.setDescription("剁手, 剁手, 剁手...............\n剁手节来啦\n购买包邮\n");
        good.setCount(9 * i);
        good.setId("999" + i);
        good.setDate(new Date(System.currentTimeMillis()).toLocaleString());

        Image image = new Image(mTestResId[i]);
        User user = new User();
        user.setNickname("发布者" + i);
        user.setDescription("仅供测试");
        user.setPhone("120888888888");
        user.setAvatar(R.drawable.ic_default_avatar);

        good.setImage(image);
        good.setUser(user);
        return good;
    }
}
