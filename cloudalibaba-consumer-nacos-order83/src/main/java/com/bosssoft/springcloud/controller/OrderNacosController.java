package com.bosssoft.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.bosssoft.springcloud.DTO.LoginDTO;
import com.bosssoft.springcloud.PO.MenuInfo;
import com.bosssoft.springcloud.PO.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * @author 张东海
 * @date 2020/7/23
 * @description
 */
@Controller
@Slf4j
public class OrderNacosController
{
    @Resource
    private RestTemplate restTemplate;

    public LoginDTO loginDTO;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class);
    }

    @PostMapping("/consumer/payment/login")
    public String login(String username, String password){
        UserInfo userInfo = new UserInfo();
        userInfo.setName(username);
        userInfo.setPassword(password);
        this.loginDTO = restTemplate.postForObject(serverURL + "/payment/login", userInfo, LoginDTO.class);
        return loginDTO.getUrl();
    }

    @GetMapping("/consumer/payment/getMenus")
    public Object getMenus(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("token",this.loginDTO.getToken());
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        return restTemplate.exchange(serverURL+"/payment/getMenus/"+this.loginDTO.getToken(), HttpMethod.GET, requestEntity, List.class);
    }

    @Test
    public void test(){
        JwtBuilder builder= Jwts.builder().setId("1")
                .setSubject("zs")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"zhangdh");
        String token = builder.compact();
        Claims claims =
                Jwts.parser().setSigningKey("zhangdh").parseClaimsJws(token).getBody();
        System.out.println("id:"+claims.getId());
        System.out.println("subject:"+claims.getSubject());
        System.out.println("IssuedAt:"+claims.getIssuedAt());

    }

}

