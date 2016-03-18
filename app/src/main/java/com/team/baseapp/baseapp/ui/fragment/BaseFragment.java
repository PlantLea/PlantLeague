package com.team.baseapp.baseapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.baseapp.baseapp.util.BusUtil;

/**
 * 基类Fragment, 所有Fragment继承它
 * Created by lynnzc on 16-3-18.
 */
public class BaseFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        //EventBus 订阅
        BusUtil.register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //EventBus 解除订阅
        BusUtil.unregister(this);
    }
}
