package com.jianzh5.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jam
 * 公众号：JAVA日知录
 * @date 2022/6/30 22:38
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> System.out.println("发车了"));

        for(int j = 0; j < 4; j++) {
            new Thread(new CyclicWorker(cyclicBarrier)).start();
        }
    }

    static class CyclicWorker implements Runnable{
        private CyclicBarrier cyclicBarrier;
        CyclicWorker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            for (int i = 0 ; i < 2 ;i++){
                String name = Thread.currentThread().getName();
                System.out.println("乘客"+name +":" + i);
                try {
                    cyclicBarrier.await();
                }catch (InterruptedException | BrokenBarrierException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
