package com.bosssoft.springcloud.entity.dto;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO {
    protected BigInteger key;
    protected String label;
    protected String disabled;

    public BaseDTO(BigInteger key, String label) {
        this.key = key;
        this.label = label;
    }
}
