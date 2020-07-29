package com.bosssoft.springcloud.entity.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author 张东海
 * @date 2020/7/27
 * @description
 */
@Data
public class Payment {
    @Id
    private Integer id;
    @Column
    private String name;
}
