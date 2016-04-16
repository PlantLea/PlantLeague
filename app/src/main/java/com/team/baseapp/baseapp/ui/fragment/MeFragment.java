package com.team.baseapp.baseapp.ui.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.model.MenuModel;
import com.team.baseapp.baseapp.ui.adapter.MeRecyclerAdapter;
import com.team.baseapp.baseapp.ui.base.BaseFragment;
import com.team.baseapp.baseapp.ui.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 我 fragment
 * Created by lynnzc on 16-4-15.
 */
public class MeFragment extends BaseFragment {
    private RecyclerView rv_me;
    private MeRecyclerAdapter mAdapter;
    private List<MenuModel> menus;
    //title
    private String[] titles = new String[]{
            "发布",
            "售出",
            "到手",
            "收藏",
            "设置"
    };
    //icon
    private int[] iconRes = new int[]{
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView(View root) {
        initMeRecyclerView(root);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        initMenus();
        mAdapter = new MeRecyclerAdapter(getContext(), menus);
        rv_me.setAdapter(mAdapter);
    }

    @Override
    public void initHeaderView(@NonNull View header) {
        TextView tv_title = (TextView) header.findViewById(R.id.tv_title);
        tv_title.setText("个人信息");
    }

    @Override
    public int getHeaderRes() {
        //返回 < 0 则不实现
        return R.layout.include_header;
    }

    /**
     * 初始化recyclerview
     *
     * @param root
     */
    private void initMeRecyclerView(View root) {
        rv_me = (RecyclerView) root.findViewById(R.id.rv_me);
        rv_me.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_me.addItemDecoration(
                new DividerItemDecoration(
                        getContext().getResources().getDrawable(R.drawable.default_divider)
                        , false, true));
    }

    /**
     * 初始化menu
     */
    private void initMenus() {
        menus = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            MenuModel menuModel = new MenuModel(titles[i], iconRes[i]);
            menus.add(menuModel);
        }
    }
}
