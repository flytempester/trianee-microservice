package com.bosssoft.RBAC.service.impl;

import com.bosssoft.RBAC.entity.PO.MenuInfoPO;
import com.bosssoft.RBAC.entity.PO.RoleMenuPO;
import com.bosssoft.RBAC.entity.PO.UserRolePO;
import com.bosssoft.RBAC.DAO.mapper.MenuInfoMapper;
import com.bosssoft.RBAC.DAO.mapper.RoleMenuMapper;
import com.bosssoft.RBAC.DAO.mapper.UserRoleMapper;
import com.bosssoft.RBAC.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
    private RoleMenuMapper roleMenuMapper;
    @Resource
    private MenuInfoMapper menuInfoMapper;

    @Override
    public List<BigInteger> getRoleIdsByUserId(BigInteger uid){
        UserRolePO userRolePO = new UserRolePO();
        userRolePO.setUserId(uid);
        List<UserRolePO> userRolePOS = userRoleMapper.select(userRolePO);
        ArrayList<BigInteger> roleIds = new ArrayList<>();
        for (UserRolePO selectedUserRolePO : userRolePOS) {
            roleIds.add(selectedUserRolePO.getRoleId());
        }
        return roleIds;
    }

    @Override
    public List<MenuInfoPO> getMenusByRoleIds(List<BigInteger> roleIds){
        RoleMenuPO roleMenu = new RoleMenuPO();
        HashSet<MenuInfoPO> menuInfoPOS = new HashSet<>();
        MenuInfoPO menuInfoPO = new MenuInfoPO();
        for (BigInteger roleId : roleIds) {
            roleMenu.setRoleId(roleId);
            List<RoleMenuPO> roleMenus = roleMenuMapper.select(roleMenu);
            for (RoleMenuPO selectedRoleMenu : roleMenus) {
                menuInfoPO.setId(selectedRoleMenu.getMenuId());
                menuInfoPOS.add(menuInfoMapper.selectOne(menuInfoPO));
            }
        }
        return new ArrayList<>(menuInfoPOS);
    }

    @Override
    public List<MenuInfoPO> getMenusByUserId(BigInteger uid){
        List<BigInteger> roleIds = getRoleIdsByUserId(uid);
        return getMenusByRoleIds(roleIds);
    }
}
