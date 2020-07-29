package com.bosssoft.springcloud.service.impl;

import com.bosssoft.springcloud.DAO.mapper.PaymentMapper;
import com.bosssoft.springcloud.DAO.mapper.UserInfoMapper;
import com.bosssoft.springcloud.DTO.LoginDTO;
import com.bosssoft.springcloud.PO.UserInfo;
import com.bosssoft.springcloud.service.LoginService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author 张东海
 * @date 2020/7/27
 * @description
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public LoginDTO login(String username, String password){
        UserInfo userInfo = new UserInfo();
        userInfo.setName(username);
        UserInfo user = userInfoMapper.selectOne(userInfo);
        JwtBuilder builder= Jwts.builder().setId(user.getId().toString())
                .setSubject(user.getName())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"zhangdh");
        if(user != null && user.getPassword().equals(password)){
            return new LoginDTO("/main",builder.compact());
        }
        else {
            return new LoginDTO("/login","");
        }
    }

}
