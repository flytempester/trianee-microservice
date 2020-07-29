package com.bosssoft.RBAC.controller;

import com.bosssoft.RBAC.DTO.UserDTO;
import com.bosssoft.RBAC.PO.UserInfo;
import com.bosssoft.RBAC.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 张东海
 * @date 2020/7/27
 * @description
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/getAllUsers")
    public UserDTO[] getAllUsers(){
        return userService.getAllUsers();
    }

}
