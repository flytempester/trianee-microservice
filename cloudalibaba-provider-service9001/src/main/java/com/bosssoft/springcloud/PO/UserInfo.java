package com.bosssoft.springcloud.PO;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author 张东海
 * @date 2020/7/27
 * @description
 */
@Data
public class UserInfo {
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private LocalDateTime createTime;
    @Column
    private LocalDateTime updateTime;
}
