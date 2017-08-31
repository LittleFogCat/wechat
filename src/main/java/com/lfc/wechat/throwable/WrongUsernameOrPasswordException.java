package com.lfc.wechat.throwable;

/**
 * Created by LittleFogCat on 2017/8/31.
 */

public class WrongUsernameOrPasswordException extends Exception {
    public WrongUsernameOrPasswordException() {
        super("用户名或密码错误");
    }

    public WrongUsernameOrPasswordException(String message) {
        super(message);
    }
}
