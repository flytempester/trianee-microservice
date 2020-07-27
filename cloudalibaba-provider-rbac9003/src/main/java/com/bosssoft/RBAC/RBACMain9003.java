package com.bosssoft.RBAC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 张东海
 * @date 2020/7/26
 * @description
 */
@SpringBootApplication
@MapperScan("com.bosssoft.RBAC.DAO.mapper")
@EnableDiscoveryClient
public class RBACMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(RBACMain9003.class,args);
    }
}
