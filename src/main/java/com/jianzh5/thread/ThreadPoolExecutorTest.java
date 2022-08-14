package com.jianzh5.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jam
 * 公众号：JAVA日知录
 * @date 2022/7/27 11:27
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                1,
                10L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2),
                new MyThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy() //既不抛弃任务也不抛出异常，直接使用主线程来执行此任务
        );

        threadPoolExecutor.allowCoreThreadTimeOut(true);  //如果线程池一直闲置并超过了 keepAliveTime 所指定的时间，核心线程就会被终止。

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

    }

    static class MyThreadFactory implements ThreadFactory {
        private final AtomicInteger count = new AtomicInteger(0);
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName = "MyThread" + count.addAndGet(1);
            t.setName(threadName);
            return t;
        }
    }
}
