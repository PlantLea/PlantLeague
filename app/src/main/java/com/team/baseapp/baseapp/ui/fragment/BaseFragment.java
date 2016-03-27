package com.team.baseapp.baseapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.baseapp.baseapp.util.BusUtils;

/**
 * 基类Fragment, 所有Fragment继承它
 * Created by lynnzc on 16-3-18.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);
        initView();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        //EventBus 订阅
        BusUtils.register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //EventBus 解除订阅
        BusUtils.unregister(this);
    }

    @LayoutRes
    protected abstract int getLayoutResource();

    /**
     * 所有findViewById, 以及初始化相关的view component
     */
    protected abstract void initView();
}
