package com.bosssoft.rbac.entity.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * @author 张东海
 * @date 2020/7/26
 * @description
 */
@Data
@Table(name = "role_info")
public class RoleInfoPO {
    @Id
    private BigInteger id;
    @Column
    private String name;
    @Column
    private LocalDateTime createTime;
    @Column
    private LocalDateTime updateTime;
}
