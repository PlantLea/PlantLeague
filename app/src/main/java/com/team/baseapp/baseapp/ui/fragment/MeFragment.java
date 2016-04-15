package com.team.baseapp.baseapp.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.ui.base.BaseFragment;

/**
 * 我 fragment
 * Created by lynnzc on 16-4-15.
 */
public class MeFragment extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initHeader(View header) {
        TextView tv_title = (TextView) header.findViewById(R.id.tv_title);
        tv_title.setText("个人信息");
    }

    @Override
    public int getHeaderRes() {
        //返回 < 0 则不实现
        return R.layout.include_header;
    }
}
