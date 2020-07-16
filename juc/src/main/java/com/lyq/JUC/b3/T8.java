package com.lyq.JUC.b3;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class T8 {

    static Random r = new Random();
    static MarryPhaser phaser = new MarryPhaser();


    public static void main(String[] args) {
        phaser.bulkRegister(8);
        for (int i = 0; i < 6; i++) {
            final int nameIndex = i;
            new Thread(()->{
                Man p = new Man("Man " + nameIndex);
                p.arrive();
                phaser.arriveAndAwaitAdvance();

                p.eat();
                phaser.arriveAndAwaitAdvance();

                p.plan();
                phaser.arriveAndAwaitAdvance();

                p.leave();
                phaser.arriveAndAwaitAdvance();
            }).start();

        }


    }




    static class MarryPhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("�����˵����ˣ�");
                    return false;
                case 1:
                    System.out.println("�����˳����ˣ�");
                    return false;
                case 2:
                    System.out.println("�����˿����ݣ�");
                    return false;
                case 3:
                    System.out.println("�������뿪�ˣ�");
                    System.out.println("���������");
                    return true;
                default:
                    return true;
            }

        }
    }




    static class Man {
        String name;

        public Man(String name) {
            this.name = name;
        }

        public void arrive() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s �����ֳ���\n", name);
        }

        public void eat() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s ����!\n", name);
        }

        public void leave() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s �뿪��\n", name);
        }

        public void plan() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s �����ݣ�\n", name);
        }
    }
    static void milliSleep(int milli) {
        try {
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
