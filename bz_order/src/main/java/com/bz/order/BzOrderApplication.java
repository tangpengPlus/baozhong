package com.bz.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.bz.dao.mapper")
public class BzOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BzOrderApplication.class, args);
	}
}
