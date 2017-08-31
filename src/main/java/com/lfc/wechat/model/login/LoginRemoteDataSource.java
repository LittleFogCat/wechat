package com.lfc.wechat.model.login;

import android.util.Log;

import com.lfc.wechat.entity.Account;
import com.lfc.wechat.login.LoginListener;
import com.lfc.wechat.login.RegisterListener;
import com.lfc.wechat.throwable.WrongUsernameOrPasswordException;

import java.util.Arrays;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class LoginRemoteDataSource implements LoginDataSource {
    private static final String TAG = "LoginRemoteDataSource";

    @Override
    public void login(String username, String password, final LoginListener loginListener) {
        BmobQuery<Account> queryName = new BmobQuery<>();
        queryName.addWhereEqualTo("username", username);
        BmobQuery<Account> queryWord = new BmobQuery<>();
        queryWord.addWhereEqualTo("password", password);

        BmobQuery<Account> query = new BmobQuery<>();
        query.and(Arrays.asList(queryName, queryWord));
        query.findObjects(new FindListener<Account>() {
            @Override
            public void done(List<Account> list, BmobException e) {
                if (e != null) {
                    loginListener.onLoginFailed(e);
                } else if (list == null || list.isEmpty()) {
                    loginListener.onLoginFailed(new WrongUsernameOrPasswordException());
                } else {
                    Log.d(TAG, "done: " + list);
                    loginListener.onLoginSuccess();
                }
            }
        });
    }

    @Override
    public void register(final String username, final String password, final RegisterListener registerListener) {
        BmobQuery<Account> query = new BmobQuery<>();
        query.addWhereEqualTo("username", username);
        query.findObjects(new FindListener<Account>() {
            @Override
            public void done(List<Account> list, BmobException e) {
                if (e != null) {
                    registerListener.onRegisterFailure(e);
                } else if (list != null && !list.isEmpty()) {
                    registerListener.onRegisterFailure(new WrongUsernameOrPasswordException("用户已存在"));
                } else {
                    final Account account = new Account();
                    account.setUsername(username);
                    account.setPassword(password);
                    account.save(new SaveListener<String>() {
                        @Override
                        public void done(String objectId, BmobException e) {
                            if (e != null) {
                                registerListener.onRegisterFailure(e);
                            } else if (objectId == null || objectId.equals("")) {
                                registerListener.onRegisterFailure(new Throwable("未知错误"));
                            } else {
                                account.setObjectId(objectId);
                                registerListener.onRegisterSuccess(account);
                            }
                        }
                    });
                }
            }
        });
    }
}
