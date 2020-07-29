package com.bosssoft.springcloud.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 张东海
 * @date 2020/7/28
 * @description
 */
@Getter
@Setter
@AllArgsConstructor
public class LoginDTO {
    private String url;
    private String token;
}
