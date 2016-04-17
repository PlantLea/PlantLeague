package com.team.baseapp.baseapp.ui.activity;

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

        tv_title.setText("我的发布");
        iv_left.setImageResource(R.drawable.ic_left_arrow);
    }

    private void onBackClicked() {
        finish();
    }
}
