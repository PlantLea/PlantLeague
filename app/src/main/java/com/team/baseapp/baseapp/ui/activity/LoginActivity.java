package com.team.baseapp.baseapp.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.model.LoginModel;
import com.team.baseapp.baseapp.ui.base.BaseActivity;
import com.team.baseapp.baseapp.util.UIUtils;

/**
 * 登陆界面 activity
 * Created by lynnzc on 16-3-26.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_login;
    private TextView tv_register;
    private EditText et_user;
    private EditText et_psw;
    private CheckBox cb_rm_psw;

    private LoginModel mLoginModel;

    /**
     * 以下的方法均运行于 onCreate内
     *
     * @return layout布局资源
     */
    @Override
    protected int getLayoutResource() {
        //返回layout布局资源
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        //初始化界面控件
        //findViewById, 更改状态等
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_register = (TextView) findViewById(R.id.tv_register);
        et_user = (EditText) findViewById(R.id.et_user);
        et_psw = (EditText) findViewById(R.id.et_psw);
        cb_rm_psw = (CheckBox) findViewById(R.id.cb_rm_psw);
    }

    @Override
    protected void initListener() {
        btn_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);

        cb_rm_psw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //只有状态改变才会触发
                if (b) {
                    //选中状态
                    mLoginModel.setRemembered(true);
                } else {
                    mLoginModel.setRemembered(false);
                }
            }
        });
    }

    @Override
    protected void initData() {
        mLoginModel = new LoginModel(this);

        mLoginModel.setLoginCallback(new LoginModel.LoginCallback() {
            @Override
            public void onSuccess() {
                //登录成功
                actionToMain();
            }

            @Override
            public void onFailed() {
                //登录失败
                UIUtils.showToast(LoginActivity.this, "登录失败");
            }
        });

        if (mLoginModel.isRemembered()) {
            cb_rm_psw.setChecked(true);
            et_user.setText(mLoginModel.getUser());
            et_psw.setText(mLoginModel.getPsw());
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                //登录按钮
                login();
                break;
            case R.id.tv_register:
                actionToRegister();
                break;
            default:
                break;
        }
    }

    /**
     * 登录逻辑
     */
    private void login() {
        mLoginModel
                .login(et_user.getText().toString().trim(),
                        et_psw.getText().toString().trim());
    }

    /**
     * 跳转到注册页面
     */
    private void actionToRegister() {
        //TODO 跳转到注册
        startActivity(new Intent(this, RegisterActivity.class));
    }

    /**
     * 跳转到主页面
     */
    private void actionToMain() {
        //跳转到主菜单
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
