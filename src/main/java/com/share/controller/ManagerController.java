package com.share.controller;

import com.share.pojo.Manager;
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
@RequestMapping("/manager")
public class ManagerController {
    private static Logger logger=Logger.getLogger(ManagerController.class);
    @Autowired
    private IManagerService managerService;

    private Manager manager;
    @RequestMapping(value = "/login.from",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public @ResponseBody
    Object managerLogin(HttpServletRequest request, HttpServletResponse response ){
        String name=request.getParameter("name").trim();
        String pwd=request.getParameter("pwd").trim();
        manager=new Manager();
        manager.setMname(name);
        manager.setMpassword(pwd);
        Manager res=managerService.login(manager);
        if(res!=null){
            logger.info(res);
            return "1";
        }
        else{
            logger.error("0");
            return "0";
        }

    }
}