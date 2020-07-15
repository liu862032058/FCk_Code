package com.lyq.JUC.a1;

public class T2 {

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                System.out.println("Hello 1!");
            }
        }
    }
    static class MyThread2 implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                System.out.println("Hello 2!");
            }

        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyThread2()).start();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                System.out.println("Hello 3!");
            }
        }).start();
    }

}
