package com.association.College_project.task;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.Executor;

/**
 * @author xinjianCHEN
 * @date 2022/8/19 10:46
 */
@Component
@EnableAsync
@EnableScheduling
public class task {
    //每日0.执行
    @Async
//    @Scheduled(cron = "0 0 0 * * ?")
    public void task1() {
        System.out.println("task当前线程：" + Thread.currentThread().getName() + " 当前时间" + LocalDateTime.now());
    }

    @Async
//    @Scheduled(cron = "0 0 0 * * ?")
    public void task2() {
        System.out.println("task当前线程：" + Thread.currentThread().getName() + " 当前时间" + LocalDateTime.now());
    }

    /**
     * TaskExecutor实现为每个任务启动一个新线程，异步执行它。 支持通过“concurrencyLimit”bean 属性限制并发线程。
     * 默认情况下，并发线程数是无限的，所以使用默认的线程池有导致内存溢出的风险。
     * @return
     */
    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setMaxPoolSize(50);
        taskExecutor.setQueueCapacity(200);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadNamePrefix("自定义线程-");
        taskExecutor.setAwaitTerminationSeconds(60);
        return taskExecutor;
    }
}
