package com.team.baseapp.baseapp.ui.activity;

import android.view.View;
import android.widget.ImageView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.ui.base.BaseActivity;

/**
 * 商品详情 activity
 * Created by lynnzc on 16-4-17.
 */
public class GoodDetailActivity extends BaseActivity
        implements View.OnClickListener {
    private ImageView iv_left, iv_right;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_good_detail;
    }

    @Override
    protected void initView() {
        initHeader();
    }

    @Override
    protected void initListener() {
        iv_left.setOnClickListener(this);
        iv_right.setOnClickListener(this);
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
            case R.id.iv_right:
                onBookmark();
                break;
        }
    }

    private void initHeader() {
        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_right = (ImageView) findViewById(R.id.iv_right);
        iv_left.setVisibility(View.VISIBLE);
        iv_right.setVisibility(View.VISIBLE);
    }

    private void onBackClicked() {
        //回退
        finish();
    }

    private void onBookmark() {
        //TODO 触发收藏
    }
}
