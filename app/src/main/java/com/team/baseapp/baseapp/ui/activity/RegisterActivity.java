package com.team.baseapp.baseapp.ui.activity;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.model.RegisterModel;
import com.team.baseapp.baseapp.ui.base.BaseActivity;
import com.team.baseapp.baseapp.util.UIUtils;

/**
 * 处理注册逻辑
 * Created by m1830 on 16-3-27.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_register;
    private EditText et_user;
    private EditText et_psw;
    private EditText et_repsw;
    private ImageView iv_left;
    private TextView tv_title;

    private RegisterModel mRegisterModel;

    /**
     * 以下的方法均运行于 onCreate内
     *
     * @return layout布局资源
     */
    @Override
    protected int getLayoutResource() {
        //返回layout布局资源
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        //初始化界面控件
        //findViewById, 更改状态等
        btn_register = (Button) findViewById(R.id.btn_register);
        et_user = (EditText) findViewById(R.id.et_user);
        et_psw = (EditText) findViewById(R.id.et_psw);
        et_repsw = (EditText) findViewById(R.id.et_repsw);
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_left = (ImageView) findViewById(R.id.iv_left);

        initHeader();
    }

    @Override
    protected void initListener() {
        iv_left.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mRegisterModel = new RegisterModel(this);

        mRegisterModel.setRegisterCallback(new RegisterModel.RegisterCallback() {
            @Override
            public void onSuccess() {
                //注册成功
                UIUtils.showToast(RegisterActivity.this, "注册成功");
                actionToLogin();
            }

            @Override
            public void onFailed() {
                //注册失败
                UIUtils.showToast(RegisterActivity.this, "注册失败, 用户名可能重复");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                //注册按钮
                register();
                break;
            case R.id.iv_left:
                onBackClicked();
            default:
                break;
        }
    }

    /**
     * 注册逻辑
     */
    private void register() {
        mRegisterModel
                .register(et_user.getText().toString().trim(),
                        et_psw.getText().toString().trim(),
                        et_repsw.getText().toString().trim());
    }

    /**
     * 跳转到登陆页面
     */
    private void actionToLogin() {
//        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void onBackClicked() {
        finish();
    }

    private void initHeader() {
        tv_title.setText("注册");
        iv_left.setImageResource(R.drawable.ic_left_arrow);
        iv_left.setVisibility(View.VISIBLE);
    }
}