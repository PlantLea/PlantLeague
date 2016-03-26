package com.team.baseapp.baseapp.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.team.baseapp.baseapp.util.BusUtils;

/**
 * activity基类,所有activity继承它
 * Created by lynnzc on 16-3-15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        initView();
        initListener();
        initData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //订阅
        BusUtils.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除订阅
        BusUtils.unregister(this);
    }

    /**
     * 返回 root layout resource
     *
     * @return
     */
    @LayoutRes
    protected abstract int getLayoutResource();

    /**
     * 所有findViewById, 以及初始化相关的view component
     */
    protected abstract void initView();

    /**
     * 绑定listener
     */
    protected abstract void initListener();

    /**
     * usecase
     */
    protected abstract void initData();
}
