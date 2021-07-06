package com.shashank.ms2.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.jms.Queue;
import java.util.concurrent.Executor;

@Configuration
public class AppConfig {


    @Bean
    @Qualifier("fileExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(100);
        //executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("file-writer");
    }
}
