package com.bosssoft.rbac.dao.mapper;

import com.bosssoft.rbac.dao.mapper.provider.MenuInfoProvider;
import com.bosssoft.rbac.entity.po.MenuInfoPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigInteger;
import java.util.List;

public interface MenuInfoMapper extends Mapper<MenuInfoPO> {
    @SelectProvider(type = MenuInfoProvider.class,method = "selectMenusByRoleIds")
    List<MenuInfoPO> selectMenusByRoleIds(@Param("roleIds") List<BigInteger> roleIds);
}
