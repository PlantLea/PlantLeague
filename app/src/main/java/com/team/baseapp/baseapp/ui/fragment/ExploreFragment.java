package com.team.baseapp.baseapp.ui.fragment;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.ui.base.BaseFragment;

/**
 * 发现 fragment
 * Created by lynnzc on 16-4-15.
 */
public class ExploreFragment extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_explore;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initHeaderView(@NonNull View header) {
        TextView tv_title = (TextView) header.findViewById(R.id.tv_title);
        tv_title.setText("发现");
    }

    @Override
    public int getHeaderRes() {
        return R.layout.include_header;
    }
}
