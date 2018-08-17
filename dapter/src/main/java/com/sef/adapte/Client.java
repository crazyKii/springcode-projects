package com.sef.adapte;

import org.junit.Test;

/**
 * Created by zhangyongjie on 2018/8/16.
 */
public class Client {

    @Test
    public void testObject() {
        //QQ
        ThridLoginService loginForQQAdapter = new LoginForQQAdapter(new LoginService());
        loginForQQAdapter.loginThrid("MMMMXXXXXXX");

        //微信
        ThridLoginService loginForWechatAdapter = new LoginForWechatAdapter(new LoginService());
        loginForWechatAdapter.loginThrid("MMMMXXXXXXX");
    }
}
