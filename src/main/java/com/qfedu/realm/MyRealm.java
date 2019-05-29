package com.qfedu.realm;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    // 返回用户的授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取登录的用户名
        String name = (String) principals.getPrimaryPrincipal();

        // 获取用户的角色和权限信息
        List<String> roles = userDao.findRoleByName(name);
        List<String> perms = userDao.findPermsByName(name);
        // 授权对象
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 设置角色信息
        authorizationInfo.setRoles(new HashSet<>(roles));
        // 设置权限信息
        authorizationInfo.setStringPermissions(new HashSet<>(perms));

        return authorizationInfo;
    }

    // 查询数据库，返回用户的认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取登录的用户名
        String name = (String) token.getPrincipal();

        User user = userDao.findByName(name);

        if(user == null){
            return new SimpleAuthenticationInfo(null, null, this.getName());
        }else{
            return new SimpleAuthenticationInfo(name, user.getPassword(), this.getName());
        }
    }
}
