package com.team.baseapp.baseapp.model;

import android.content.Context;
import android.content.SharedPreferences;
import com.team.baseapp.baseapp.entity.User;

/**
 * Created by m1830 on 2016/3/27.
 */
public class RegisterModel implements BaseModel{
    private final static String SHARE_REGISTER_PREF = "register_share_pre";
    private final static String SHARE_USR = "usr";
    private final static String SHARE_PSW = "psw";
    private final static String SHARE_REPSW = "repsw";
    private SharedPreferences registerPrefs;
    private RegisterCallback registerCallback;
    private User user;

    public RegisterModel(Context context) {
        //初始化登录所需
        registerPrefs = context
                .getSharedPreferences(SHARE_REGISTER_PREF, Context.MODE_PRIVATE);
        //初始化用户
        user = new User();
        user.setUsr(registerPrefs.getString(SHARE_USR, ""));
        user.setPsw(registerPrefs.getString(SHARE_PSW, ""));
    }

    public void setRegisterCallback(RegisterCallback loginCallback) {
        this.registerCallback = loginCallback;
    }

    /**
     * 多态的运用, 重载方法
     *
     * @param usr      登录用户
     * @param psw      登录密码
     * @param callback 绑定回调接口
     */
    public void login(String usr, String psw, RegisterCallback callback) {
        setRegisterCallback(callback);
        register(usr, psw);
    }

    /**
     * 注册主体方法
     *
     * @param usr 注册用户
     * @param psw 注册密码
     */
    public void register(String usr, String psw) {
        if (verify(usr, psw)) {
            // 注册成功
            registerPrefs.edit()
                    .putString(SHARE_USR, usr)
                    .putString(SHARE_PSW, psw)
                    .apply();


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
     * @param psw 注册密码
     * @return 验证是否注册成功
     */
    public boolean verify(String usr, String psw) {
        return usr.equals("admin") && psw.equals("123456");
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
