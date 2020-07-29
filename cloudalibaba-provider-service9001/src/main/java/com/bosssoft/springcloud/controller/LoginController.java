package com.bosssoft.springcloud.controller;

import com.bosssoft.springcloud.entity.dto.LoginDTO;
import com.bosssoft.springcloud.entity.po.UserInfoPO;
import com.bosssoft.springcloud.service.impl.LoginServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigInteger;
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

    @RequestMapping("/login")
    @ResponseBody
    public LoginDTO login(@RequestBody UserInfoPO userInfoPO) {
        return loginService.login(userInfoPO.getName(),userInfoPO.getPassword());
    }


    @GetMapping("/getMenus/{token}")
    @ResponseBody
    public Object getMenus(@PathVariable String token){
        Claims claims =
                Jwts.parser().setSigningKey("zhangdh").parseClaimsJws(token).getBody();
        BigInteger id = new BigInteger(claims.getId());
        return restTemplate.getForObject(serverURL+"/getMenus/"+id, List.class);
    }
}
