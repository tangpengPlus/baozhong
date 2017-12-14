package com.bz.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.bz.task.config.thread.TaskThreadPoolConfig;
@SpringBootApplication
@EnableAsync  
@EnableScheduling
@ComponentScan
@EnableConfigurationProperties({TaskThreadPoolConfig.class} )
public class BzAutomatiTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(BzAutomatiTaskApplication.class, args);
	}
}
