package com.team.baseapp.baseapp.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.baseapp.baseapp.ui.view.IHeaderViewBuilder;
import com.team.baseapp.baseapp.util.BusUtils;

/**
 * 基类Fragment, 所有Fragment继承它
 * Created by lynnzc on 16-3-18.
 */
public abstract class BaseFragment extends Fragment implements IHeaderViewBuilder {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);
        initHeader(attachHeader((ViewGroup) view));
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //init listener
        initListener();
        //init data
        initData();
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
     * 所有主界面findViewById, 以及初始化相关的view component
     */
    protected abstract void initView(View v);

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initHeaderView(@NonNull View header);

    @Override
    public void initHeader(View header) {
        if (header == null) {
            //不显示header
            return;
        }

        initHeaderView(header);
    }

    @Override
    public boolean isHideHeader() {
        //default
        return false;
    }

    @Override
    public abstract int getHeaderRes();

    @Override
    public View attachHeader(ViewGroup parent) {
        if (isHideHeader() || getHeaderRes() <= 0) {
            //不显示header
            return null;
        }

        View header = LayoutInflater.from(getContext()).inflate(getHeaderRes(), null);
        //加到顶部
        parent.addView(header, 0);
        return header;
    }
}
