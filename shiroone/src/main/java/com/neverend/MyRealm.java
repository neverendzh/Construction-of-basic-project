package com.neverend;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by Administrator on 2018/2/27.
 */
public class MyRealm implements Realm {
    @Override
    public String getName() {
        return "my-realm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = new String (token.getPassword());
        if(!"jak".equals(username)){
            throw new UnknownAccountException("用户不存在");
        }
        if(!"123".equals(password)){
            throw new IncorrectCredentialsException("密码或用户名错误");
        }
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}