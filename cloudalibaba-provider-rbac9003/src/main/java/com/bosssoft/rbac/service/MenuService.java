package com.bosssoft.rbac.service;

import com.bosssoft.rbac.entity.po.MenuInfoPO;

import java.math.BigInteger;
import java.util.List;

public interface MenuService {
    List<BigInteger> getRoleIdsByUserId(BigInteger uid);
    List<MenuInfoPO> getMenusByRoleIds(List<BigInteger> roleIds);
    List<MenuInfoPO> getMenusByUserId(BigInteger uid);
}
