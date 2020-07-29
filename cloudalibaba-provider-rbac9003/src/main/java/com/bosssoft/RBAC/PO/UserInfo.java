package com.bosssoft.RBAC.PO;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * @author 张东海
 * @date 2020/7/26
 * @description
 */
@Data
public class UserInfo {
    @Id
    private BigInteger id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private LocalDateTime createTime;
    @Column
    private LocalDateTime updateTime;
}
