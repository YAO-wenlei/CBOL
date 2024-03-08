package org.cbol.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yaowenlei
 * @date 2023年12月03日 12:21 下午
 */

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "org.cbol.user.dao.mapper")
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
