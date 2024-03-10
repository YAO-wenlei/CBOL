package org.cbol;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 厂牌模块
 * @author yaowenlei
 */
@SpringBootApplication
@MapperScan(basePackages = "org.cbol.dao.mapper")
@EnableDiscoveryClient
public class ClubServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClubServiceApplication.class, args);
	}
}
