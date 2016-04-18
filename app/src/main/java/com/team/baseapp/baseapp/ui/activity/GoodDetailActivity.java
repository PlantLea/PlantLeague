package com.team.baseapp.baseapp.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.ui.base.BaseActivity;

/**
 * 商品详情 activity
 * Created by lynnzc on 16-4-17.
 */
public class GoodDetailActivity extends BaseActivity
        implements View.OnClickListener {
    private ImageView iv_left;
    private ImageView iv_right;
    private TextView tv_buy;
    private TextView tv_title;
    private TextView tv_des;
    private TextView tv_name;
    private TextView tv_price;
    private TextView tv_call;
    private TextView tv_phone;
    private TextView tv_time;


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_good_detail;
    }

    @Override
    protected void initView() {
        initHeader();

        tv_buy = (TextView) findViewById(R.id.tv_pay);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_des = (TextView) findViewById(R.id.tv_des);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_price = (TextView) findViewById(R.id.tv_price);
        tv_call = (TextView) findViewById(R.id.tv_call);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_time = (TextView) findViewById(R.id.tv_time);
    }

    @Override
    protected void initListener() {
        iv_left.setOnClickListener(this);
        iv_right.setOnClickListener(this);
        tv_call.setOnClickListener(this);
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
            case R.id.tv_call:
                onCall();
                break;
        }
    }

    private void initHeader() {
        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_right = (ImageView) findViewById(R.id.iv_right);
        iv_left.setVisibility(View.VISIBLE);
        iv_right.setVisibility(View.VISIBLE);
        iv_right.setImageResource(R.drawable.selector_star);
        iv_right.setSelected(false);
    }

    private void onBackClicked() {
        //回退
        finish();
    }

    private void onBookmark() {
        //TODO 触发收藏
        iv_right.setSelected(!iv_right.isSelected());
    }

    private void onCall() {
        //触发打电话
        Intent intent = new Intent(Intent.ACTION_CALL,
                Uri.parse("tel:" + tv_phone.getText().toString()));
        startActivity(intent);
    }
}
