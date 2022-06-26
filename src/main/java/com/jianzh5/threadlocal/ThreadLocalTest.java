package com.jianzh5.threadlocal;

import java.util.Arrays;
import java.util.List;

/**
 * @author jam
 * 公众号：JAVA日知录
 * @date 2022/6/26 12:23
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        // 存值
        threadLocal.set(Arrays.asList("Java日知录", "Java 面试题"));
        // 取值
        List list = (List) threadLocal.get();
        System.out.println(list.size());
        System.out.println(threadLocal.get());

        //删除值
        threadLocal.remove();
        System.out.println(threadLocal.get());
    }
}
