package com.team.baseapp.baseapp.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.ui.base.BaseActivity;

/**
 * 设置　activity
 * Created by lynnzc on 16-4-17.
 */
public class SettingActivity extends BaseActivity
        implements View.OnClickListener {
    private ImageView iv_left;
    private TextView tv_title;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {
        intiHeader();
    }

    @Override
    protected void initListener() {
        iv_left.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                onBackClicked();
                break;
        }
    }

    /**
     * 初始化header
     */
    private void intiHeader() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_left = (ImageView) findViewById(R.id.iv_left);

        iv_left.setVisibility(View.VISIBLE);
        iv_left.setImageResource(R.drawable.ic_left_arrow);
        tv_title.setText("设置");
    }

    /**
     * 返回
     */
    private void onBackClicked() {
        finish();
    }
}
