package com.jianzh5.juc;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jam
 * 公众号：JAVA日知录
 * @date 2022/6/30 22:27
 */
public class CountDownLatchDemo {
    @SneakyThrows
    public static void main(String[] args) {
        // 医院闭锁
        CountDownLatch hospitalLatch = new CountDownLatch(1);
        // 患者闭锁
        CountDownLatch patientLatch = new CountDownLatch(5);
        System.out.println("患者排队");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            executorService.execute(() -> {
                try {
                    hospitalLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("体检：" + j);
                patientLatch.countDown();
            });
        }
        System.out.println("医生上班");
        hospitalLatch.countDown();
        patientLatch.await();
        System.out.println("医生下班");
        executorService.shutdown();
    }
}
