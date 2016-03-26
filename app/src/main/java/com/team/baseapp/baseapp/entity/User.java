package com.team.baseapp.baseapp.entity;

/**
 * app 用户
 * Created by lynnzc on 16-3-26.
 */
public class User {
    //账号
    private String usr;
    //密码
    private String psw;

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
