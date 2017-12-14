package com.bz.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.bz.manage.dao.sys")
@EnableCaching
public class BzManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BzManageApplication.class, args);
	}
}
