package com.bosssoft.springcloud.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

/**
 * @author 张东海
 * @date 2020/7/29
 * @description
 */
@Getter
@Setter
@NoArgsConstructor
public class RoleMenuDTO extends BaseDTO {

    private BigInteger roleId;
    private BigInteger menuId;

    public RoleMenuDTO(BigInteger key,BigInteger roleId,BigInteger menuId){
        this.key = key;
        this.roleId = roleId;
        this.menuId = menuId;
    }
}
