package com.lyq.JUC.b3.t7;

import java.util.concurrent.CountDownLatch;

public class Boss implements Runnable{

    private CountDownLatch countDownLatch;


    public Boss(CountDownLatch downLatch){
        this.countDownLatch = downLatch;
    }

    @Override
    public void run() {
        System.out.println("�ϰ����ڵ����еĹ��˸����......");
        try {
            this.countDownLatch.await();
        } catch (InterruptedException e) {
        }
        System.out.println("���˻�����ˣ��ϰ忪ʼ����ˣ�");
    }
}
