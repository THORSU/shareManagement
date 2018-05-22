package com.share.controller;

import com.alibaba.fastjson.JSON;
import com.share.pojo.Object_1;
import com.share.service.IObjectService;
import com.share.service.IRedisService;
import org.apache.log4j.Logger;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
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
 * @Author: QuincySu
 * @Date: 2018/4/23
 */
@Controller
@RequestMapping("/object")
public class ObjectController {
    private static Logger logger = Logger.getLogger(ObjectController.class);
    @Autowired
    private IObjectService objectService;
    @Autowired
    private IRedisService redisService;
    private Object_1 object_1 = new Object_1();

    @RequestMapping(value = "/addObject.from", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody
    Object addObject(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        try {
            //商品名
            String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
            //商品价格
            String price = request.getParameter("price").toString();
            //todo 避免获得的值为乱码
            //商品备注
            String remark = new String(request.getParameter("remark").getBytes("iso-8859-1"), "utf-8");
            //商品编码
            String code = Long.toString(System.currentTimeMillis());
            //从cookie获得merchantName
            final Cookie[] cookies = request.getCookies();
            String merchantName = "";
            if (cookies != null) {
                for (final Cookie cookie : cookies) {
                    if ("merchantName".equals(cookie.getName())) {
                        merchantName = cookie.getValue();
                    }
                }
            }
            //商品状态默认是 0未上架
            object_1.setObjectStatus("0");
            object_1.setMerchantName(merchantName);
            object_1.setObjectCode(code);
            object_1.setObjectName(name);
            object_1.setObjectPrice(price);
            object_1.setObjectRemark(remark);
            //向mysql增加数据
            Integer num = objectService.addObject(object_1);
            Object_1 res1 = objectService.getObject(code);
            //向redis增加数据
            redisService.addObject(res1);
            //向es增加数据
            String data = JSON.toJSONString(object_1);
            Settings settings = ImmutableSettings.settingsBuilder()
                    .put("cluster.name", "elasticsearch").build();
            TransportClient client = new TransportClient(settings);
            client.addTransportAddress(new InetSocketTransportAddress("101.132.64.173", 9300));
            IndexResponse res = client.prepareIndex("share", "objects").setSource(data).get();
            if (res.isCreated()) {
                System.out.println("创建成功!");
            }
            client.close();
            if (num == 1) {
                return "add success";
            } else {
                return "add fail";
            }
        } catch (Exception e) {
            logger.error("ObjectController.addObject error e[{}].", e);
            return "server error";
        }
    }

}
