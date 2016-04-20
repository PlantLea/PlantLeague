package com.team.baseapp.baseapp.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.entity.Good;
import com.team.baseapp.baseapp.entity.Image;
import com.team.baseapp.baseapp.model.ImageModel;
import com.team.baseapp.baseapp.model.UserModel;
import com.team.baseapp.baseapp.ui.base.BaseActivity;
import com.team.baseapp.baseapp.util.UIUtils;

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
    private EditText et_price;
    private TextView tv_title;
    private TextView tv_publish;
    private LinearLayout fl_image;
    private ImageView iv_add;
    //记录图片数据
    private ImageModel imageModel;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_publish_good;
    }

    @Override
    protected void initView() {
        initHeader();

        tv_publish = (TextView) findViewById(R.id.tv_publish);
        et_title = (EditText) findViewById(R.id.et_title);
        et_price = (EditText) findViewById(R.id.et_price);
        et_des = (EditText) findViewById(R.id.et_des);
        fl_image = (LinearLayout) findViewById(R.id.fl_image);
        iv_add = (ImageView) findViewById(R.id.iv_add);
    }

    @Override
    protected void initListener() {
        iv_left.setOnClickListener(this);
        tv_publish.setOnClickListener(this);
        iv_add.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        //初始化图片model
        imageModel = new ImageModel(new Image(R.drawable.ic_default_avatar));
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
            case R.id.iv_add:
                onImageAdd();
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
    @SuppressWarnings("deprecation")
    private void onPublish() {
        Good good = new Good();
        good.setName(et_title.getText().toString());
        good.setDescription(et_des.getText().toString());
        good.setUser(UserModel.getInstance().getUser());
        good.setImage(imageModel.getImage());
        good.setPrice(Integer.parseInt(et_price.getText().toString()));
        good.setDate(new Date(System.currentTimeMillis()).toLocaleString());
        //添加发布
        UserModel.getInstance().addRelease(good);

        UIUtils.showToast(this, "发布成功");
        finish();
    }

    /**
     * 添加图片 add
     */
    private void onImageAdd() {
        UIUtils.showToast(this, "为方便测试, 并未实现从相册获取图片");
        ImageView im = new ImageView(this);
        im.setLayoutParams(iv_add.getLayoutParams());
        im.setImageResource(R.drawable.ic_good1);
        imageModel.addRes(R.drawable.ic_good1);
        fl_image.addView(im, (fl_image.getChildCount() == 0)
                ? 0 : (fl_image.getChildCount() - 1));
    }
}
