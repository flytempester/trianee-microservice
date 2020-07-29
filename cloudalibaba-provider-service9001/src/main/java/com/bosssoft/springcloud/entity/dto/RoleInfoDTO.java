package com.bosssoft.springcloud.entity.dto;

import java.math.BigInteger;

/**
 * @author 张东海
 * @date 2020/7/29
 * @description
 */
public class RoleInfoDTO extends BaseDTO{

    public RoleInfoDTO(BigInteger key, String label) {
        super(key, label);
    }
}
