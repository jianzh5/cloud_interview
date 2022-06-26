package com.jianzh5.threadlocal;

/**
 * @author jam
 * 公众号：JAVA日知录
 * @date 2022/6/26 12:27
 */
public class InheritableThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
        inheritableThreadLocal.set("Java日知录");
        new Thread(() -> System.out.println(inheritableThreadLocal.get())).start();
    }
}
