package com.share.controller;

import com.share.pojo.Manager;
import com.share.service.IManagerRedisService;
import com.share.service.IManagerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: QuincySu
 * @Date: 2018/4/23
 */
@Controller
@RequestMapping("/share")
public class ManagerController {
    private static Logger logger = Logger.getLogger(ManagerController.class);
    @Autowired
    private IManagerService managerService;
    @Autowired
    private IManagerRedisService managerRedisService;
    private Manager manager = new Manager();

    //管理员登录
    @RequestMapping(value = "/login.from", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody
    Object managerLogin(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name").trim();
        String pwd = request.getParameter("pwd").trim();
        //redis登录
        Manager rest = managerRedisService.getManger(name);
        if (rest != null) {
            if (rest.getMpassword().equals(pwd)) {
                logger.info("redis登录成功");
                return "1";
            } else {
                return "0";
            }
        } else {
            //mysql登录
            manager.setMname(name);
            manager.setMpassword(pwd);
            Manager res = managerService.login(manager);
            managerRedisService.addManager(res);
            if (res != null) {
                logger.info("mysql登录成功");
                return "1";
            } else {
                logger.error("0");
                return "0";
            }
        }
    }

    //管理员注册
    @RequestMapping(value = "/signUp.from", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody
    Object managerSignUp(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name").trim();
        String pwd = request.getParameter("pwd").trim();
        manager.setMname(name);
        manager.setMpassword(pwd);
        //验证是否已注册(mysql)
        Manager res = managerService.getManager(manager);
        if (res!=null){
            return "already exist";
        }
        //向mysql添加数据
        Integer num = managerService.signUp(manager);
        //从mysql获取列id
        Manager res1=managerService.getManager(manager);
        logger.info(res1.toString());
        //向redis添加数据
        managerRedisService.addManager(res1);
        if (num == 1) {
            return "sign up success";
        } else {
            return "sign up fail";
        }
    }
}
