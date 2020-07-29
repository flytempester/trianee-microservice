package com.bosssoft.RBAC.service.impl;

import com.bosssoft.RBAC.DAO.mapper.AdminMapper;
import com.bosssoft.RBAC.PO.Admin;
import com.bosssoft.RBAC.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 张东海
 * @date 2020/7/27
 * @description
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public String login(String username,String password){
        Admin admin = new Admin();
        admin.setName(username);
        Admin administraor = adminMapper.selectOne(admin);
        if(administraor != null && administraor.getPassword().equals(password)){
            return "rbac/main";
        }
        else {
            return "rbac/login";
        }
    }
}
