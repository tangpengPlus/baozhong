package com.bz.merchant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.bz.dao.mapper")
public class BzMerchantApplication {

	public static void main(String[] args) {
		SpringApplication.run(BzMerchantApplication.class, args);
	}
}
