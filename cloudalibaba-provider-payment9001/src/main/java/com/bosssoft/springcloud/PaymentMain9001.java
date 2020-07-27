package com.bosssoft.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 张东海
 * @date 2020/7/23
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.bosssoft.springcloud.DAO.mapper")
public class PaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9001.class,args);
    }
}
