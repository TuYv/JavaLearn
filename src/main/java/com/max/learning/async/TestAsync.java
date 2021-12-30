package com.max.learning.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

/**
 * @author Rick
 * @date 2021-12-12 18:22
 */
@EnableAsync
@Configuration
public class TestAsync implements AsyncConfigurer {
    @Override public Executor getAsyncExecutor() {
        return AsyncConfigurer.super.getAsyncExecutor();
    }

    @Override public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return AsyncConfigurer.super.getAsyncUncaughtExceptionHandler();
    }
}
