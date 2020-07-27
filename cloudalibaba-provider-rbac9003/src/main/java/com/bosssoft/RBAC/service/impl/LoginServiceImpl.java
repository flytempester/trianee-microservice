package com.bosssoft.RBAC.service.impl;

import com.bosssoft.RBAC.DAO.mapper.AdminMapper;
import com.bosssoft.RBAC.PO.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 张东海
 * @date 2020/7/27
 * @description
 */
@Service
public class LoginServiceImpl {

    @Resource
    private AdminMapper adminMapper;

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
