package com.jianzh5.juc;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jam
 * 公众号：JAVA日知录
 * @date 2022/6/30 22:51
 */
public class SemaphoreDemo2 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        ThreadPoolExecutor semaphoreThread = new ThreadPoolExecutor(10, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 3; i++) {
            semaphoreThread.execute(() -> {
                try {
                    semaphore.release();
                    System.out.println("Hello,Java日知录");
                    TimeUnit.SECONDS.sleep(2);
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
