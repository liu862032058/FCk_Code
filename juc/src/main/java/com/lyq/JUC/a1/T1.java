package com.lyq.JUC.a1;

public class T1 {

    private long count = 0;
    private void add10K() {
        int idx = 0;
        while(idx++ < 10000) {
            count += 1;
            System.out.println(" : "+ count );
        }
    }
    public long calc() throws InterruptedException {
        final T1 test = new T1();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(()->{
            test.add10K();
//            System.out.println(1+" : "+ count );
        });
        Thread th2 = new Thread(()->{
            test.add10K();
//            System.out.println(2+" : "+ count );
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        T1 test = new T1();
        test.calc();
    }

}
