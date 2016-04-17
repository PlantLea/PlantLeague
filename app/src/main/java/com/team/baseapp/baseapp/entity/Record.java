package com.team.baseapp.baseapp.entity;

import com.team.baseapp.baseapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟注册的后台记录
 * Created by m1830 on 2016/4/15.
 */
public class Record {
    private List<User> record;

    private Record() {
        record = new ArrayList<>();
        //默认用户
        User initUser = new User();
        initUser.setUsr("admin");
        initUser.setPsw("1234");
        initUser.setAvatar(R.mipmap.ic_launcher);
        //添加默认用户
        add(initUser);
    }

    private static final class RecordHolder {
        private static final Record INSTANCE = new Record();
    }

    public static Record getInstance() {
        return RecordHolder.INSTANCE;
    }

    /**
     * 模拟添加注册用户
     *
     * @param user
     */
    public void add(User user) {
        record.add(user);
    }

    /**
     * 检查待注册用户是否有重复
     *
     * @param usr
     * @return
     */
    public boolean checkUser(String usr) {
        for (User user : record) {
            if (user.getUsr().equals(usr)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 模拟用户登录验证
     *
     * @param user
     * @param psw
     * @return
     */
    public boolean verify(String user, String psw) {
        if (user == null || psw == null || user.equals("") || psw.equals("")) {
            return false;
        }

        for (User usr : record) {
            if (usr.getUsr().equals(user)) {
                return usr.getPsw().equals(psw);
            }
        }
        return false;
    }
}
