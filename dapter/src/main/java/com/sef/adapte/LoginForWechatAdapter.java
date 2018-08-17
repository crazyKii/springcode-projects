package com.sef.adapte;

public class LoginForWechatAdapter implements ThridLoginService {

    /**
     * 被适配的对象
     */
    LoginService loginService;

    /**
     * 构造方法
     *
     * @param loginService loginService
     */
    public LoginForWechatAdapter(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 第三方登录
     *
     * @param openId 第三方openid
     */
    public void loginThrid(String openId) {
        System.out.println("微信 注册登录");
        loginService.regist(openId, null);
        loginService.login(openId, null);
    }
}