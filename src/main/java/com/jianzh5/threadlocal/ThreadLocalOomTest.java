package com.jianzh5.threadlocal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jam
 * 公众号：JAVA日知录
 * @date 2022/6/26 12:28
 */
public class ThreadLocalOomTest {
    static ThreadLocal threadLocal = new ThreadLocal();
    static Integer MOCK_MAX = 10000;
    static Integer THREAD_MAX = 100;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_MAX);
        for (int i = 0; i < THREAD_MAX; i++) {
            executorService.execute(() -> {
                threadLocal.set(new ThreadLocalOomTest().getList());
                System.out.println(Thread.currentThread().getName());
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    List getList() {
        List list = new ArrayList();
        for (int i = 0; i < MOCK_MAX; i++) {
            list.add("Version：JDK 8");
            list.add("ThreadLocal");
            list.add("Author：Java日知录");
            list.add("DateTime：" + LocalDateTime.now());
            list.add("Test：ThreadLocal OOM");
        }
        return list;
    }
}
