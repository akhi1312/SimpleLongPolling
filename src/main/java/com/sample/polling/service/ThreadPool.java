package com.sample.polling.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPool{


        @Value("${contacts.thread.core-pool}")
        private int corePoolSize;

        @Value("${contacts.thread.max-pool}")
        private int maxPoolSize;

        @Value("${contacts.queue.capacity}")
        private int queueCapacity;



        @Bean(name="myThreadPool")
        public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(corePoolSize);
            executor.setMaxPoolSize(maxPoolSize);
            executor.setQueueCapacity(queueCapacity);
            executor.initialize();
            return executor;
        }

}
