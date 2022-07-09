package com.jianzh5.juc;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author jam
 * 公众号：JAVA日知录
 * @date 2022/7/9 22:53
 */
public class CasAbaDemo {
    public static void main(String[] args) {
        String name = "飘渺";
        String newName = "Jam";
        String newName2 = "飘渺Jam";
        // 创建原子引用包装类，并将值设置成 飘渺
        AtomicStampedReference<String> asr = new AtomicStampedReference<>(name, 1);
        System.out.println("值：" + asr.getReference() + " | Stamp：" + asr.getStamp());

        // 比较并交换，如果主内存的值为 飘渺，则将值设置成 Jam，并将版本号 +1
        asr.compareAndSet(name, newName, asr.getStamp(), asr.getStamp() + 1);
        System.out.println("值：" + asr.getReference() + " | Stamp：" + asr.getStamp());

        //现在主内存的值是Jam，再次比较交换，如果主内存的值为 飘渺，则将值设置成 飘渺Jam，比较失败
        asr.compareAndSet(name, newName2, asr.getStamp(), asr.getStamp() + 1);
        System.out.println("值：" + asr.getReference() + " | Stamp：" + asr.getStamp());
    }
}
