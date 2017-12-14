package com.bz.agent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bz.dao.mapper")
public class BzAgentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BzAgentApplication.class, args);
	}
}
