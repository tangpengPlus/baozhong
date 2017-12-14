package com.bz.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.bz.dao.mapper")
public class BzUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(BzUserApplication.class, args);
	}
}
