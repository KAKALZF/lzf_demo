package com.ample16.backend.controller;

import com.ample16.backend.entity.AuthScope;
import javafx.application.Application;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.Controller;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    ApplicationContext applicationContext;

    @PostMapping("/login")
    @ResponseBody
    public String login(String username, String password) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            SecurityUtils.getSubject().login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "账号或者密码错误";
        }

        return "success";
    }

    @GetMapping("/testShiro")
    @ResponseBody
    public String testShiro() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        System.out.println(session);
        System.out.println("=====principals========" + principals.getPrimaryPrincipal());
        System.out.println("=====session========" + session.getAttribute("userInfo"));
        return "success";
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "logout success";
    }


    @GetMapping("/loginRemind")
    @ResponseBody
    public String loginRemind() {
        SecurityUtils.getSubject().logout();
        return "please login first";
    }

    @GetMapping("/permission")
    @ResponseBody
    @AuthScope("需要xx权限")
    public String permission() {
        Subject subject = SecurityUtils.getSubject();
//        权限校验,这里只是单个测试,拦截器统一校验
        //subject.checkPermission("abc");
        subject.checkPermission("how_are_you");
        return "permit";
    }

    /**
     * 测试加载所有的权限
     *
     * @return
     */
    @GetMapping("/loadPermission")
    @ResponseBody
    public HashMap loadPermission() {
        HashMap<String, String> map = new HashMap<>();
        //获取所有的RestController
        Map<String, Object> controllerMap = applicationContext.getBeansWithAnnotation(RestController.class);
        for (String controllerName : controllerMap.keySet()) {
            System.out.println(controllerName + ":" + controllerMap.get(controllerName).getClass().getName());
            Method[] methods = controllerMap.get(controllerName).getClass().getMethods();
            for (Method method : methods) {
                AuthScope annotation = method.getAnnotation(AuthScope.class);
                if (annotation != null) {
                    System.out.println(annotation.value());
                    map.put(annotation.value(), controllerMap.get(controllerName).getClass().getName() + "|" + method.getName());
                }
            }
        }
        return map;
    }
}
