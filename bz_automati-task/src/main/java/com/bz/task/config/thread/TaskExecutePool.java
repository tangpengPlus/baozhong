package com.bz.task.config.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration  
@EnableAsync  
public class TaskExecutePool {  
  private final Logger logger=LoggerFactory.getLogger(TaskExecutePool.class);
    @Autowired  
    private TaskThreadPoolConfig config;  
  
    @Bean  
    public Executor myTaskAsyncPool() {  
    	logger.info(">>>>>>>>>>>>>>>>>>>>>>>初始化线程池用于多线程实现<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();  
        executor.setCorePoolSize(config.getCorePoolSize());  
        executor.setMaxPoolSize(config.getMaxPoolSize());  
        executor.setQueueCapacity(config.getQueueCapacity());  
        executor.setKeepAliveSeconds(config.getKeepAliveSeconds());  
        executor.setThreadNamePrefix("MyExecutor-");  
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());  
        executor.initialize();  
        return executor;  
    }  
}
