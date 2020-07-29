package com.bosssoft.rbac.service.impl;

import com.bosssoft.rbac.entity.po.MenuInfoPO;
import com.bosssoft.rbac.entity.po.RoleMenuPO;
import com.bosssoft.rbac.entity.po.UserRolePO;
import com.bosssoft.rbac.dao.mapper.MenuInfoMapper;
import com.bosssoft.rbac.dao.mapper.RoleMenuMapper;
import com.bosssoft.rbac.dao.mapper.UserRoleMapper;
import com.bosssoft.rbac.service.MenuService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.awt.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 张东海
 * @date 2020/7/26
 * @description
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private MenuInfoMapper menuInfoMapper;

    @Override
    public List<BigInteger> getRoleIdsByUserId(BigInteger uid){
        UserRolePO userRolePO = new UserRolePO();
        userRolePO.setUserId(uid);
        List<UserRolePO> userRolePOs = userRoleMapper.select(userRolePO);
        return userRolePOs.stream()
                .parallel()
                .map(selectedUserRolePO -> selectedUserRolePO.getRoleId())
                .collect(Collectors.toList());
    }

    @Override
    public List<MenuInfoPO> getMenusByRoleIds(List<BigInteger> roleIds){
        return menuInfoMapper.selectMenusByRoleIds(roleIds);
    }

    @Override
    public List<MenuInfoPO> getMenusByUserId(BigInteger uid){
        List<BigInteger> roleIds = getRoleIdsByUserId(uid);
        return getMenusByRoleIds(roleIds);
    }
}
