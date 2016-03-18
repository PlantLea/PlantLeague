package com.team.baseapp.baseapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.team.baseapp.baseapp.event.BaseEvent;
import com.team.baseapp.baseapp.util.BusUtil;

/**
 * activity基类,所有activity继承它
 * Created by lynnzc on 16-3-15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //订阅
        BusUtil.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除订阅
        BusUtil.unregister(this);
    }
}
