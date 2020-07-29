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
public class UserRoleDTO extends BaseDTO{

    private BigInteger userId;
    private BigInteger roleId;

    public UserRoleDTO(BigInteger key,BigInteger userId,BigInteger roleId){
        this.key = key;
        this.userId = userId;
        this.roleId = roleId;
    }

}
