package com.team.baseapp.baseapp.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.ui.base.BaseActivity;

/**
 * 发布商品 activity
 * Created by lynnzc on 16-4-17.
 */
public class PublishGoodActivity extends BaseActivity
        implements View.OnClickListener {
    private ImageView iv_left;
    private TextView tv_title;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_publish_good;
    }

    @Override
    protected void initView() {
        initHeader();
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

    private void initHeader() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_left.setVisibility(View.VISIBLE);
        tv_title.setText("发布");
    }

    /**
     * 返回 click
     */
    private void onBackClicked() {
        finish();
    }
}
