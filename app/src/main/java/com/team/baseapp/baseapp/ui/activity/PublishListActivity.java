package com.team.baseapp.baseapp.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.ui.base.BaseActivity;

/**
 * 我的发布列表 activity
 * Created by lynnzc on 16-4-17.
 */
public class PublishListActivity extends BaseActivity
        implements View.OnClickListener {
    private TextView tv_title;
    private ImageView iv_left;
    private ImageView iv_right;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_publish_list;
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
                //跳转发布界面
                onAddGoodClicked();
                break;
            default:
                break;
        }
    }

    private void initHeader() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_right = (ImageView) findViewById(R.id.iv_right);

        tv_title.setText("我的发布");
        iv_left.setVisibility(View.VISIBLE);
        iv_left.setImageResource(R.drawable.ic_left_arrow);
        iv_right.setVisibility(View.VISIBLE);
        iv_right.setImageResource(R.drawable.ic_add);
    }

    private void onBackClicked() {
        finish();
    }

    private void onAddGoodClicked() {
        //跳转发布界面
        startActivity(new Intent(this, PublishGoodActivity.class));
    }
}
