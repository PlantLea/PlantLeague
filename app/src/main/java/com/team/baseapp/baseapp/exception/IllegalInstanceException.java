package com.team.baseapp.baseapp.exception;

/**
 * 不合法实例化异常
 * Created by lynnzc on 16-3-18.
 */
public class IllegalInstanceException extends RuntimeException {
    public IllegalInstanceException() {
        //单例，私有类，内部类等不合法实例化
        super("不合法的实例化操作");
    }
}
