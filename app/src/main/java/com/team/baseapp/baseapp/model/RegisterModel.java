package com.team.baseapp.baseapp.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.team.baseapp.baseapp.entity.Record;
import com.team.baseapp.baseapp.entity.User;
import com.team.baseapp.baseapp.util.UIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by m1830 on 2016/3/27.
 */
public class RegisterModel implements BaseModel{
    private SharedPreferences registerPrefs;
    private RegisterCallback registerCallback;
    private Context context;
//    private User user;

    public RegisterModel(Context context) {
        this.context = context;
        //初始化登录所需
        //初始化用户记录
    }

    public void setRegisterCallback(RegisterCallback loginCallback) {
        this.registerCallback = loginCallback;
    }

    /**
     * 注册主体方法
     *
     * @param usr 注册用户
     * @param psw 注册密码
     */
    public void register(String usr, String psw, String repsw) {
        if (!checkPSW(psw, repsw)) {
            //加入输入密码不一致
            UIUtils.showToast(context, "密码输入不一致");
            return;
        }

        if (verify(usr)) {
            // 注册成功
            User user = new User();
            user.setUsr(usr);
            user.setPsw(psw);
            //记录新用户
            Record.getInstance().add(user);

            if (registerCallback != null) {
                //回调登录成功方法
                registerCallback.onSuccess();
            }
        } else {
            if (registerCallback != null) {
                //回调登录失败方法
                registerCallback.onFailed();
            }
        }
    }

    /**
     * 验证注册账号和密码是否合法
     *
     * @param usr 注册用户
     * @return 验证是否注册成功
     */
    private boolean verify(String usr) {
        return Record.getInstance().checkUser(usr);
    }

    /**
     * 判断密码是否相同
     *
     * @param psw
     * @param repsw
     * @return
     */
    private boolean checkPSW(String psw, String repsw) {
        return psw != null
                && repsw != null
                && !psw.equals("") // 密码不为空
                && psw.equals(repsw); // 输入密码一致
    }

    /**
     * 注册回调接口
     */
    public interface RegisterCallback {
        //成功
        void onSuccess();

        //失败
        void onFailed();
    }
}
