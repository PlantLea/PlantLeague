package com.team.baseapp.baseapp.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.entity.Good;
import com.team.baseapp.baseapp.model.UserModel;
import com.team.baseapp.baseapp.ui.base.BaseActivity;

import java.util.Date;

/**
 * 发布商品 activity
 * Created by lynnzc on 16-4-17.
 */
public class PublishGoodActivity extends BaseActivity
        implements View.OnClickListener {
    private ImageView iv_left;
    private EditText et_title;
    private EditText et_des;
    private TextView tv_title;
    private TextView tv_publish;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_publish_good;
    }

    @Override
    protected void initView() {
        initHeader();

        tv_publish = (TextView) findViewById(R.id.tv_publish);
        et_title = (EditText) findViewById(R.id.et_title);
        et_des = (EditText) findViewById(R.id.et_des);
    }

    @Override
    protected void initListener() {
        iv_left.setOnClickListener(this);
        tv_publish.setOnClickListener(this);
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
            case R.id.tv_publish:
                onPublish();
                break;
        }
    }

    private void initHeader() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_left.setVisibility(View.VISIBLE);
        iv_left.setImageResource(R.drawable.ic_left_arrow);
        tv_title.setText("发布");
    }

    /**
     * 返回 click
     */
    private void onBackClicked() {
        finish();
    }

    /**
     * 发布 click
     */
    private void onPublish() {
        Good good = new Good();
        good.setName(et_title.getText().toString());
        good.setDescription(et_des.getText().toString());
        good.setUser(UserModel.getInstance().getUser());
        good.setDate(new Date(System.currentTimeMillis()).toLocaleString());
        //添加发布
        UserModel.getInstance().addRelease(good);
    }
}
