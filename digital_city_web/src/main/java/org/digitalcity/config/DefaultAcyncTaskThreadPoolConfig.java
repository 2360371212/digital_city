package org.digitalcity.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Description:异步任务线程池
 *
 * @author xupengxin
 * @date 2024/1/23
 */
@EnableAsync
@Configuration
public class DefaultAcyncTaskThreadPoolConfig implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {  // 线程池配置
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("email_");
        executor.initialize();  // 线程池初始化
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {   // 异常处理配置
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
