package com.team.baseapp.baseapp.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.baseapp.baseapp.Constants;
import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.entity.Good;
import com.team.baseapp.baseapp.ui.base.BaseActivity;

/**
 * 商品详情 activity
 * Created by lynnzc on 16-4-17.
 */
public class GoodDetailActivity extends BaseActivity
        implements View.OnClickListener {
    private FrameLayout fl_header;
    private ImageView iv_left;
    private ImageView iv_right;
    private ImageView iv_bg;
    private TextView tv_buy;
    private TextView tv_title;
    private TextView tv_des;
    private TextView tv_name;
    private TextView tv_price;
    private TextView tv_call;
    private TextView tv_phone;
    private TextView tv_time;
    //显示的商品
    private Good good;


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_good_detail;
    }

    @Override
    protected void initView() {
        initHeader();
        fl_header = (FrameLayout) findViewById(R.id.fl_header);
        fl_header.setBackgroundResource(R.drawable.bg_trans_header);

        iv_bg = (ImageView) findViewById(R.id.iv_bg);
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
        good = getData();
        bindGood(good);
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
        iv_left.setImageResource(R.drawable.ic_back);
        iv_right.setImageResource(R.drawable.selector_star);
        iv_right.setSelected(false);
    }

    private void onBackClicked() {
        //回退
        finish();
    }

    private void onBookmark() {
        //TODO 触发收藏
        iv_right.setEnabled(!iv_right.isEnabled());
    }

    private void onCall() {
        //TODO 触发打电话
        Intent intent = new Intent(Intent.ACTION_DIAL,  
                Uri.parse("tel:" + tv_phone.getText().toString()));
        startActivity(intent);
    }

    private Good getData() {
        return getIntent().getParcelableExtra(Constants.PARAM_GOOD_DATA);
    }

    private void bindGood(Good good) {
        if (good == null) {
            return;
        }

        if (good.getImage() != null) {
            iv_bg.setBackgroundResource(good.getImage().getAvatar());
        }

//        tv_title.setText(good.getName());
        tv_name.setText(good.getName());
        tv_des.setText(good.getDescription());
        tv_price.setText("价格 : " + good.getPrice());
        tv_time.setText(good.getDate());
        if (good.getUser() != null) {
            tv_phone.setText(good.getUser().getPhone());
        }
    }
}
