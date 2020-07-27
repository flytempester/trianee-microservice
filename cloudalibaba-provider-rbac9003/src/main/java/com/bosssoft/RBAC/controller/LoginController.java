package com.bosssoft.RBAC.controller;

import com.bosssoft.RBAC.PO.MenuInfo;
import com.bosssoft.RBAC.service.MainService;
import com.bosssoft.RBAC.service.impl.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 张东海
 * @date 2020/7/26
 * @description
 */
@Controller
public class LoginController {

    @Resource
    private LoginServiceImpl loginService;
    @Resource
    private MainService mainService;

    @GetMapping("/payment/getMenus/{id}")
    @ResponseBody
    public List<MenuInfo> getMenus(@PathVariable("id")Integer id)
    {
        return mainService.getMenusByUserId(id);
    }

    @PostMapping("/rbac/login")
    public String login(String username,String password)
    {
        return loginService.login(username,password);
    }
}
