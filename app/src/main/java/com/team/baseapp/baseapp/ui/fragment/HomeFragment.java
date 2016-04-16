package com.team.baseapp.baseapp.ui.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.model.BannerModel;
import com.team.baseapp.baseapp.ui.adapter.HomeRecyclerAdapter;
import com.team.baseapp.baseapp.ui.base.BaseFragment;
import com.team.baseapp.baseapp.ui.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页 fragment
 * Created by lynnzc on 16-4-15.
 */
public class HomeFragment extends BaseFragment {
    private RecyclerView rv_home;
    private HomeRecyclerAdapter mAdapter;
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
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mAdapter.getItemViewType(position)) {
                    case HomeRecyclerAdapter.ITEM_VIEW_BANNER:
                        return 2;
                    case HomeRecyclerAdapter.ITEM_VIEW_CONTENT:
                        return 2;
                    default:
                        return 1;
                }
            }
        });
        rv_home.addItemDecoration(new DividerItemDecoration(
                getContext().getResources().getDrawable(R.drawable.default_divider)
                , false, true));
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
    }
}
