package com.bosssoft.RBAC.service;

import com.bosssoft.RBAC.PO.MenuInfo;
import com.bosssoft.RBAC.PO.RoleInfo;
import com.bosssoft.RBAC.PO.RoleMenu;
import com.bosssoft.RBAC.PO.UserRole;
import com.bosssoft.RBAC.DAO.mapper.MenuInfoMapper;
import com.bosssoft.RBAC.DAO.mapper.RoleMenuMapper;
import com.bosssoft.RBAC.DAO.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author 张东海
 * @date 2020/7/26
 * @description
 */
@Service
public class MainService {
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private RoleMenuMapper roleMenuMapper;
    @Resource
    private MenuInfoMapper menuInfoMapper;

    public List<Integer> getRoleIdsByUserId(Integer uid){
        UserRole userRole = new UserRole();
        userRole.setUserId(uid);
        List<UserRole> userRoles = userRoleMapper.select(userRole);
        ArrayList<Integer> roleIds = new ArrayList<>();
        for (UserRole selectedUserRole : userRoles) {
            roleIds.add(selectedUserRole.getRoleId());
        }
        return roleIds;
    }

    public List<MenuInfo> getMenusByRoleIds(List<Integer> roleIds){
        RoleMenu roleMenu = new RoleMenu();
        HashSet<MenuInfo> menuInfos = new HashSet<>();
        MenuInfo menuInfo = new MenuInfo();
        for (Integer roleId : roleIds) {
            roleMenu.setRoleId(roleId);
            List<RoleMenu> roleMenus = roleMenuMapper.select(roleMenu);
            for (RoleMenu selectedRoleMenu : roleMenus) {
                menuInfo.setId(selectedRoleMenu.getMenuId());
                menuInfos.add(menuInfoMapper.selectOne(menuInfo));
            }
        }
        return new ArrayList<>(menuInfos);
    }

    public List<MenuInfo> getMenusByUserId(Integer uid){
        List<Integer> roleIds = getRoleIdsByUserId(uid);
        return getMenusByRoleIds(roleIds);
    }
}
