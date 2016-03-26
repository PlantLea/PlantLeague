package com.team.baseapp.baseapp.ui.activity;

import android.content.Intent;
import android.view.ViewStub;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.ui.base.BaseActivity;

/**
 * 启动界面 activity
 * Created by lynnzc on 16-3-26.
 */
public class SplashActivity extends BaseActivity {
    private ViewStub stub_main;

    /**
     * 以下的方法均运行于 onCreate内
     *
     * @return
     */
    @Override
    protected int getLayoutResource() {
        //返回layout布局资源
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        //初始化界面控件
        //findViewById, 更改状态等
        stub_main = (ViewStub) findViewById(R.id.stub_main);
        //目前不考虑启动页面有特殊引导页, 所以直接跳转
        //延迟1秒跳转到MainActivity
        stub_main.postDelayed(new Runnable() {
            @Override
            public void run() {
                //跳转
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                overridePendingTransition(
                        android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                //结束这个activity
                finish();
            }
        }, 1000);
    }

    @Override
    protected void initListener() {
        //绑定控件的监听listener
    }

    @Override
    protected void initData() {
        //数据处理
    }
}
