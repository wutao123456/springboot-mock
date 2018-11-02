package com.dlh.async.threadpool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/27 21:41
 */
@Configuration
@EnableAsync
public class AsyncConfig {

    /**
     * 线程池配置也可写在配置文件中
     * @return
     */

    @Value("${excutor.corePoolSize}")
    private int corePoolSize;

    @Value("${excutor.maxPoolSize}")
    private int maxPoolSize;

    @Value("${excutor.queueCapacity}")
    private int queueCapacity;

    @Value("${excutor.threadNamePrefix}")
    private String threadNamePrefix;

    @Bean
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(threadNamePrefix);
//        1、AbortPolicy策略
//        该策略直接抛出异常，阻止系统工作
//        2、CallerRunsPolicy策略
//        只要线程池未关闭，该策略直接在调用者线程中运行当前被丢弃的任务。显然这样不会真的丢弃任务，但是，调用者线程性能可能急剧下降。
//        3、DiscardOledestPolicy策略
//        丢弃最老的一个请求任务，也就是丢弃一个即将被执行的任务，并尝试再次提交当前任务。
//        4、DiscardPolicy策略
//        默默的丢弃无法处理的任务，不予任何处理。

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
