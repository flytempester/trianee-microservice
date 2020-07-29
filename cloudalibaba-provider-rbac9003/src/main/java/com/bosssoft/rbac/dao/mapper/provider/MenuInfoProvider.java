package com.bosssoft.rbac.dao.mapper.provider;

import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

/**
 * @author 张东海
 * @date 2020/7/29
 * @description
 */
public class MenuInfoProvider {
    public String selectMenusByRoleIds(@Param("roleIds") List<BigInteger> roleIds)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT DISTINCT m.id, m.`name` " +
                "FROM menu_info AS m left JOIN role_menu AS r " +
                "ON m.id = r.menu_id " +
                "WHERE r.role_id IN (");
        for (BigInteger roleId : roleIds) {
            builder.append("'"+roleId+"'"+",");
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        builder.append(")");
        return builder.toString();
    }
}
