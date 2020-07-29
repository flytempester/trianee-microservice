package com.bosssoft.RBAC.controller;

import com.bosssoft.RBAC.PO.MenuInfoPO;

import com.bosssoft.RBAC.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

/**
 * @author 张东海
 * @date 2020/7/26
 * @description
 */
@Controller
public class MenuController {

    @Resource
    private MenuService menuService;

    @GetMapping("/getMenus/{id}")
    @ResponseBody
    public List<MenuInfoPO> getMenus(@PathVariable("id") BigInteger id)
    {
        return menuService.getMenusByUserId(id);
    }

}
