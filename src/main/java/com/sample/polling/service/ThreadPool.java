package com.sample.polling.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPool{


        @Value("${spring.thread.core-pool}")
        private int corePoolSize;

        @Value("${spring.thread.max-pool}")
        private int maxPoolSize;

        @Value("${spring.queue.capacity}")
        private int queueCapacity;

       @Value("${spring.queue.keepAliveSeconds}")
        private int keepAliveSec;



        @Bean(name="myThreadPool")
        public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(corePoolSize);
            executor.setMaxPoolSize(maxPoolSize);
            executor.setQueueCapacity(queueCapacity);
            executor.setKeepAliveSeconds(2);
            executor.setAllowCoreThreadTimeOut(true);

            executor.initialize();
            return executor;
        }

}
