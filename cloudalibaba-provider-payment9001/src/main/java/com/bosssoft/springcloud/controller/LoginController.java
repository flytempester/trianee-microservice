package com.bosssoft.springcloud.controller;

import com.bosssoft.springcloud.PO.MenuInfo;
import com.bosssoft.springcloud.PO.UserInfo;
import com.bosssoft.springcloud.service.impl.LoginServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张东海
 * @date 2020/7/27
 * @description
 */
@Controller
@Slf4j
@RefreshScope
public class LoginController {

    @Resource
    private LoginServiceImpl loginService;

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @PostMapping("/payment/login")
    public String login(String username,String password,HttpSession session){
        return loginService.login(username,password,session);
    }

    @GetMapping("/payment/getMenus")
    @ResponseBody
    public Object getMenus(HttpSession session){
        Integer id = Integer.parseInt(session.getAttribute("userId").toString());
        return restTemplate.getForObject(serverURL+"/payment/getMenus/"+id, List.class);
    }
}
