package com.bosssoft.springcloud.service.impl;

import com.bosssoft.springcloud.DAO.mapper.PaymentMapper;
import com.bosssoft.springcloud.DAO.mapper.UserInfoMapper;
import com.bosssoft.springcloud.PO.UserInfo;
import com.bosssoft.springcloud.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
    public String login(String username, String password, HttpSession session){
        UserInfo userInfo = new UserInfo();
        userInfo.setName(username);
        UserInfo user = userInfoMapper.selectOne(userInfo);
        if(user != null && user.getPassword().equals(password)){
            session.setAttribute("userId",user.getId());
            return "/payment/main";
        }
        else {
            return "/payment/login";
        }

    }

}
