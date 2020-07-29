package com.bosssoft.RBAC.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

/**
 * @author 张东海
 * @date 2020/7/27
 * @description
 */
@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private BigInteger value;
    private String name;
    private String disabled;
    private String checked;

    public UserDTO(BigInteger value,String name){
        this.value = value;
        this.name = name;
    }

}
