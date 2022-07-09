package com.jianzh5.cpu;

/**
 * @author jam
 * 公众号：JAVA日知录
 * @date 2022/6/26 17:27
 */
public class HighCpuTest {
    public static void main(String[] args) {

        Thread highCpuThread = new Thread(()->{
            int i = 0;
            while (true){
                HignCpu cpu = new HignCpu("Java日知录",i);
                i ++;
            }
        });
        highCpuThread.setName("HignCpu");
        highCpuThread.start();
    }
}
