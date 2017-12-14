package com.bz.openweb.config.thread;


import org.springframework.boot.context.properties.ConfigurationProperties;  

/**
 * 
 *  作者:唐鹏
 *  描述:线程池参数配置
 *  备注:
 *  创建时间:2017年11月22日下午2:17:46
 */
@ConfigurationProperties(prefix = "spring.task.pool") //  
public class TaskThreadPoolConfig {  
  private int corePoolSize;  

  private int maxPoolSize;  

  private int keepAliveSeconds;  

  private int queueCapacity;

public int getCorePoolSize() {
	return corePoolSize;
}

public void setCorePoolSize(int corePoolSize) {
	this.corePoolSize = corePoolSize;
}

public int getMaxPoolSize() {
	return maxPoolSize;
}

public void setMaxPoolSize(int maxPoolSize) {
	this.maxPoolSize = maxPoolSize;
}

public int getKeepAliveSeconds() {
	return keepAliveSeconds;
}

public void setKeepAliveSeconds(int keepAliveSeconds) {
	this.keepAliveSeconds = keepAliveSeconds;
}

public int getQueueCapacity() {
	return queueCapacity;
}

public void setQueueCapacity(int queueCapacity) {
	this.queueCapacity = queueCapacity;
}  
  
  
}  
