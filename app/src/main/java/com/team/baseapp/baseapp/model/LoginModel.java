package com.team.baseapp.baseapp.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.team.baseapp.baseapp.entity.Record;
import com.team.baseapp.baseapp.entity.User;

/**
 * 处理登录逻辑
 * Created by lynnzc on 16-3-26.
 */
public class LoginModel implements BaseModel {
    private final static String SHARE_LOGIN_PREF = "login_share_pre";
    private final static String SHARE_REM_PSW = "isremember";
    private final static String SHARE_USR = "usr";
    private final static String SHARE_PSW = "psw";
    private SharedPreferences loginPrefs;
    private LoginCallback loginCallback;
    private User user;

    public LoginModel(Context context) {
        //初始化登录所需
        loginPrefs = context
                .getSharedPreferences(SHARE_LOGIN_PREF, Context.MODE_PRIVATE);
        //初始化用户
        user = new User();
        user.setUsr(loginPrefs.getString(SHARE_USR, ""));
        user.setPsw(loginPrefs.getString(SHARE_PSW, ""));
    }

    /**
     * 是否记录密码状态
     */
    public boolean isRemembered() {
        return loginPrefs.getBoolean(SHARE_REM_PSW, false);
    }

    /**
     * 记录状态设置
     *
     * @param isRem 是否记录密码
     */
    public void setRemembered(boolean isRem) {
        loginPrefs.edit().putBoolean(SHARE_REM_PSW, isRem).apply();
    }

    public void setLoginCallback(LoginCallback loginCallback) {
        this.loginCallback = loginCallback;
    }

    /**
     * 多态的运用, 重载方法
     *
     * @param usr      登录用户
     * @param psw      登录密码
     * @param callback 绑定回调接口
     */
    public void login(String usr, String psw, LoginCallback callback) {
        setLoginCallback(callback);
        login(usr, psw);
    }

    /**
     * 登录主体方法
     *
     * @param usr 登录用户
     * @param psw 登录密码
     */
    public void login(String usr, String psw) {
        if (verify(usr, psw)) {
            // 登录成功
            if (isRemembered()) {
                // 记住账号密码
                loginPrefs.edit()
                        .putString(SHARE_USR, usr)
                        .putString(SHARE_PSW, psw)
                        .apply();
            }

            if (loginCallback != null) {
                //回调登录成功方法
                loginCallback.onSuccess();
            }
        } else {
            if (loginCallback != null) {
                //回调登录失败方法
                loginCallback.onFailed();
            }
        }
    }

    /**
     * 验证登录账号和密码是否合法
     *
     * @param usr 登录用户
     * @param psw 登录密码
     * @return 验证是否登录成功
     */
    public boolean verify(String usr, String psw) {
        return Record.getInstance().verify(usr, psw);
    }

    public String getUser() {
        if (user.getUsr() == null) {
            return "";
        }
        return user.getUsr();
    }

    public String getPsw() {
        if (user.getPsw() == null) {
            return "";
        }
        return user.getPsw();
    }

    //返回登录用户token, username作为token
    public User getUserToken() {
        //返回记录的登录信息
        if (user != null) {
            return Record.getInstance().getUser(user.getUsr());
        }
        return null;
    }

    /**
     * 登录回调接口
     */
    public interface LoginCallback {
        //成功
        void onSuccess();

        //失败
        void onFailed();
    }
}
