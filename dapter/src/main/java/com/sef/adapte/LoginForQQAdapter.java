package com.sef.adapte;

/**
 * QQ登录适配
 * Created by zhangyongjie on 2018/8/16.
 */
public class LoginForQQAdapter implements ThridLoginService {

    LoginService loginService;

    public LoginForQQAdapter(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 第三方登录
     *
     * @param openId 第三方openid
     */
    public void loginThrid(String openId) {
        System.out.println("QQ 注册登录");
        loginService.regist(openId, null);
        loginService.login(openId, null);
    }
}
