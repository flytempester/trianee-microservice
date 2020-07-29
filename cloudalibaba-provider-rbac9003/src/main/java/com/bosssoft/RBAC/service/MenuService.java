package com.bosssoft.RBAC.service;

import com.bosssoft.RBAC.PO.MenuInfo;

import java.math.BigInteger;
import java.util.List;

public interface MenuService {
    List<BigInteger> getRoleIdsByUserId(BigInteger uid);
    List<MenuInfo> getMenusByRoleIds(List<BigInteger> roleIds);
    List<MenuInfo> getMenusByUserId(BigInteger uid);
}
