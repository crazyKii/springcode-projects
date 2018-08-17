package com.sef.adapte;

/**
 * Created by zhangyongjie on 2018/8/16.
 */
public interface ThridLoginService {
    /**
     * 第三方登录
     *
     * @param openId 第三方openid
     */
    public void loginThrid(String openId);
}
