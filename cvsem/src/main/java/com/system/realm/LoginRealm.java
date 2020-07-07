package com.system.realm;


import com.system.po.user;
import com.system.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jacey on 2017/6/30.
 */

@Component
public class LoginRealm extends AuthorizingRealm{

    @Resource(name = "userServiceImpl")
    private UserService userService;

    /**
     * 获取身份信息，我们可以在这个方法中，从数据库获取该用户的角色信息
     *     当调用权限验证时，就会调用此方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = (String) getAvailablePrincipal(principalCollection);

        try {
            user user = userService.findByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //通过用户名从数据库获取权限/角色信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        return info;
    }

    /**
     * 在这个方法中，进行身份验证
     *         login时调用
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用户名
        String username = (String) token.getPrincipal();
        //密码
        String password = new String((char[])token.getCredentials());

        user user = null;
        try {
            user = userService.findByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user == null) {
            //没有该用户名
            throw new UnknownAccountException();
        } else if (!password.equals(user.getPassword())) {
            //密码错误
            throw new IncorrectCredentialsException();
        }

        //身份验证通过,返回一个身份信息
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username,password,getName());

        return aInfo;
    }
}
