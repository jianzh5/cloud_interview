package com.jianzh5.threadlocal;

/**
 * @author jam
 * 公众号：JAVA日知录
 * @date 2022/6/26 12:57
 */
public class ThreadLocalTest3 {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new InheritableThreadLocal();
        threadLocal.set("Java日知录");
        ThreadLocal threadLocal2 = new ThreadLocal();
        threadLocal2.set("Java日知录");
        new Thread(() -> {
            System.out.println(threadLocal.get().equals(threadLocal2.get()));
        }).start();
    }
}
