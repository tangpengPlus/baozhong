package com.bz.openweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

import com.bz.openweb.config.thread.TaskThreadPoolConfig;
@SpringBootApplication
@EnableCaching
@EnableAsync  
@EnableConfigurationProperties({TaskThreadPoolConfig.class} )
public class BzOpenWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BzOpenWebApplication.class, args);
	}
}
