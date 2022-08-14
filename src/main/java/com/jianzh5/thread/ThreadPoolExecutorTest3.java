package com.jianzh5.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jam
 * 公众号：JAVA日知录
 * @date 2022/7/27 11:27
 */
public class ThreadPoolExecutorTest3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                2,
                10L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10)
        );

        for (int i = 0; i < 5; i++) {
            String seq = i + "";
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("I'm 飘渺" + seq);
                }
                @Override
                public String toString() {
                    return "这是第" + seq + "个任务";
                }
            });
        }
        threadPoolExecutor.shutdownNow();

        threadPoolExecutor.execute(() -> {
            System.out.println("I'm Java日知录");
        });


        // 没有来得及执行的任务会以列表的形式返回
//        List<Runnable> runnables = threadPoolExecutor.shutdownNow();
//        System.out.println("线程池已关闭");
//        for (Runnable runnable : runnables) {
//            // 打印一下未执行的任务
//            System.out.println(runnable);
//        }
    }
}
