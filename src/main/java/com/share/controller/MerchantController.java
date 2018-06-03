package com.share.controller;

import com.share.pojo.Merchant;
import com.share.service.IMerchantService;
import com.share.service.IRedisService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author: QuincySu
 * @Date: 2018/5/21
 */
@Controller
@RequestMapping("/share")
public class MerchantController {
    private static Logger logger = Logger.getLogger(ManagerController.class);

    @Autowired
    private IMerchantService merchantService;
    @Autowired
    private IRedisService managerRedisService;

    private Merchant merchant = new Merchant();

    /**
     * 商家登录
     *
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/MerchantLogin.from", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody
    Object MerchantLogin(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //商家名
        String merchantName = new String(request.getParameter("merchantName").getBytes("iso-8859-1"), "utf-8");
        //商家密码
        String merchantPassword = request.getParameter("merchantPassword").trim();
        if (merchantName.equals("") || merchantPassword.equals("")) {
            return "blank";
        }
        merchant.setMerchantName(merchantName);
        merchant.setMerchantPassword(merchantPassword);
        //获取redis
        Merchant rest = managerRedisService.getMerchant(merchantName);
        if (rest != null) {
            if (rest.getMerchantPassword().equals(merchantPassword) && rest.getMerchantStatus().equals("1")) {
                logger.info("redis登录成功");
                //向浏览器添加cookie
                Cookie name = new Cookie("merchantName", rest.getMerchantName());
                name.setPath("/");
                name.setMaxAge(60 * 60 * 24);
                response.addCookie(name);
                return "merchant login success";
            } else {
                return "merchant password error";
            }
        } else {
            //sql登录
            Merchant res = merchantService.merchantLogin(merchant);
            if (res != null) {
                if (merchantPassword.equals(res.getMerchantPassword()) || res.getMerchantStatus().equals("1")) {
                    logger.info("mysql登录成功");
                    //向浏览器添加cookie
                    Cookie name = new Cookie("merchantName", rest.getMerchantName());
                    name.setPath("/");
                    name.setMaxAge(60 * 60 * 24);
                    response.addCookie(name);
                    return "merchant login success";
                } else {
                    return "merchant password error";
                }
            } else {
                return "merchant not exist";
            }
        }
    }

    /**
     * 商家注册
     *
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/MerchantSignUp.from", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody
    Object MerchantSignUp(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //商家名
        String merchantName = new String(request.getParameter("merchantName").getBytes("iso-8859-1"), "utf-8");
        //商家密码
        String merchantPassword = request.getParameter("merchantPassword").trim();
        String merchantPassword1 = request.getParameter("merchantPassword1").trim();
        if (merchantName.equals("") || merchantPassword.equals("") || merchantPassword1.equals("")) {
            return "blank";
        } else if (!merchantPassword.equals(merchantPassword1)) {
            return "pwd different";
        } else {
            merchant.setMerchantName(merchantName);
            merchant.setMerchantPassword(merchantPassword);
            //默认未被审核
            merchant.setMerchantStatus("0");
            Merchant res = merchantService.getMerchant(merchant);
            if (res == null) {
                int num = merchantService.merchantSignUp(merchant);
                logger.info("mysql添加成功");
                Merchant rest = merchantService.getMerchant(merchant);
                //redis添加
                managerRedisService.addMerchant(rest);
                logger.info("redis添加成功");
                if (num == 1) {
                    return "merchant sign up success";
                } else {
                    return "merchant sign up fail";
                }
            } else {
                return "merchant already exist";
            }
        }
    }
}
