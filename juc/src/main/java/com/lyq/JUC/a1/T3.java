package com.lyq.JUC.a1;

import java.util.concurrent.TimeUnit;

public class T3 {
    public static void main(String[] args) {
//        testSleep();
        testYield();
//        testJoin();
    }

    static void testJoin() {
        Thread t1 = new Thread(()->{
            for(int i=0; i<10; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                    //TimeUnit.Milliseconds.sleep(500)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{

            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for(int i=0; i<10; i++) {
                System.out.println("B" + i);
                try {
                    Thread.sleep(500);
                    //TimeUnit.Milliseconds.sleep(500)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for(int i=0; i<100; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                    //TimeUnit.Milliseconds.sleep(500)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } );

        t1.start();
        t2.start();
    }
    static void testYield() {
        new Thread(()->{
            for(int i=0; i<10; i++) {
                System.out.println("A" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i%2 == 0) Thread.yield();


            }
        }).start();

        new Thread(()->{
            for(int i=0; i<10; i++) {
                System.out.println("------------B" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i%2 == 0) Thread.yield();
            }
        }).start();
    }

}
