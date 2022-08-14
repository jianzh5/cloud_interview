package com.jianzh5.thread;

import java.util.concurrent.*;

/**
 * @author jam
 * 公众号：JAVA日知录
 * @date 2022/7/27 11:27
 */
public class ThreadPoolExecutorTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                10L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2)
        );

        threadPoolExecutor.execute(() -> {
            System.out.println("Hello, Java日知录");
        });

        Future<String> submit = threadPoolExecutor.submit(() -> {
            System.out.println("Hello, 飘渺");
            return "Success";
        });

        System.out.println(submit.get());

    }


}
