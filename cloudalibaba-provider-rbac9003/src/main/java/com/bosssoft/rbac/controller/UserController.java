package com.bosssoft.rbac.controller;

import com.bosssoft.rbac.entity.dto.UserDTO;
import com.bosssoft.rbac.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 张东海
 * @date 2020/7/27
 * @description
 */
@RestController
public class UserController {

    @Resource
    private UserInfoService userService;

    @GetMapping("/getAllUsers")
    public UserDTO[] getAllUsers(){
        return userService.getAllUsers();
    }

}
