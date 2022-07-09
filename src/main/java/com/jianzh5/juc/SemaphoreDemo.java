package com.jianzh5.juc;

import java.time.LocalDateTime;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jam
 * 公众号：JAVA日知录
 * @date 2022/6/30 22:51
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        ThreadPoolExecutor semaphoreExecutor = new ThreadPoolExecutor(10,50,50, TimeUnit.SECONDS,new LinkedBlockingDeque<>());

        for (int i = 0; i < 5; i++) {
            semaphoreExecutor.execute( () -> {
                try{
                    //堵塞获取许可
                    semaphore.acquire();
                    System.out.println("Thread：" + Thread.currentThread().getName() + " 时间：" + LocalDateTime.now());
                    TimeUnit.SECONDS.sleep(2);
                    //释放许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

    }
}
