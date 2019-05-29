package com.qfedu.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/login.do")
    public String login(String name, String password){

        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        // 设置 rememberMe 功能，true wei 前台传来的参数时记住
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
            return "redirect:/list.do";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "redirect:/login.jsp";
        }

    }
}
