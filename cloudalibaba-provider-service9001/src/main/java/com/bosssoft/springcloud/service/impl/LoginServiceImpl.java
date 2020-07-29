package com.bosssoft.springcloud.service.impl;

import com.bosssoft.springcloud.dao.mapper.UserInfoMapper;
import com.bosssoft.springcloud.entity.dto.LoginDTO;
import com.bosssoft.springcloud.entity.po.UserInfoPO;
import com.bosssoft.springcloud.service.LoginService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        UserInfoPO userInfoPO = new UserInfoPO();
        userInfoPO.setName(username);
        UserInfoPO user = userInfoMapper.selectOne(userInfoPO);
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
