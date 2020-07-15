package com.lyq.JUC.b3.t11;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Students extends Thread{

    private Semaphore sp;
    private String name;

    public Students(Semaphore sp, String name) {
        this.sp = sp;
        this.name = name;
    }

    @Override
    public void run() {

        try {
            sp.acquire();
            System.out.println(name+" 拿到打饭许可");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(name+" 打好饭了");
            sp.release();
        }

    }
}
