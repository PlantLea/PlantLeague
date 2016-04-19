package com.team.baseapp.baseapp.model;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟注册的后台记录
 * Created by m1830 on 2016/4/15.
 */
public class RecordModel {
    private List<User> record;

    private RecordModel() {
        record = new ArrayList<>();
        //默认用户
        User initUser = new User();
        initUser.setUsr("admin");
        initUser.setPsw("1234");
        initUser.setAvatar(R.drawable.ic_default_avatar);
        initUser.setNickname("剁手开挂员");
        initUser.setPhone("020-110");
        initUser.setSex(true);
        initUser.setDescription("想剁谁就剁谁,　不服来买啊!");
        //添加默认用户
        add(initUser);
    }

    private static final class RecordHolder {
        private static final RecordModel INSTANCE = new RecordModel();
    }

    public static RecordModel getInstance() {
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

    /**
     * 根据用户账号, 返回记录的用户信息
     *
     * @return
     */
    public User getUser(String useraccount) {
        for (User user : record) {
            if (user.getUsr().equals(useraccount)) {
                return user;
            }
        }
        return null;
    }
}
