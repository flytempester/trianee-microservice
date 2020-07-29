package com.bosssoft.springcloud.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

/**
 * @author 张东海
 * @date 2020/7/27
 * @description
 */
@Getter
@Setter
@NoArgsConstructor
public class UserInfoDTO extends BaseDTO{

    public UserInfoDTO(BigInteger key, String label) {
        super(key, label);
    }

}
