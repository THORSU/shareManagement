package com.share.controller;

import com.share.pojo.Object_1;
import com.share.service.IObjectService;
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
@RequestMapping("/object")
public class ObjectController {
    private static Logger logger=Logger.getLogger(ObjectController.class);
    @Autowired
    private IObjectService objectService;

    private Object_1 object_1;

    @RequestMapping(value = "/addObject.from", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody
    Object managerLogin(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code").toString();
        String name = request.getParameter("name").toString();
        String price = request.getParameter("price").toString();
        String remark = request.getParameter("remark").toString();
        object_1 = new Object_1();
        object_1.setCode(code);
        object_1.setName(name);
        object_1.setPrice(price);
        object_1.setRemark(remark);
        Integer num = objectService.addObject(object_1);
        if (num == 1) {
            return "add success";
        } else {
            return "add fail";
        }
    }

}
