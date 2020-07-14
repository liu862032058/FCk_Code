package lyq.com.JUC.b3;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class T81 {
        static Phaser phaser = new MarriagePhaser();

        static class MarriagePhaser extends Phaser { //实现phaser接口
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                switch (phase) {//四个阶段
                    case 0:
                        allArrive(registeredParties);
                        return false;
                    case 1:
                        allEat(registeredParties);
                        return false;
                    case 2:
                        allLeave(registeredParties);
                        return false;
                    case 3:
                        over(registeredParties);
                        return true;
                    default:
                        return true;
                }
            }

            private boolean over(int registeredParties) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("步入洞房后结束" + registeredParties);
                return true;
            }

            private boolean allLeave(int registeredParties) {
                System.out.println("所有人离开" + registeredParties);
                return false;
            }

            private boolean allEat(int registeredParties) {
                System.out.println("所有人吃饭" + registeredParties);
                return false;
            }

            private boolean allArrive(int registeredParties) {
                System.out.println("所有人到齐" + registeredParties);
                return false;
            }
        }

        static class Person implements Runnable {
            private String name;

            public Person(String name) {
                this.name = name;
            }

            @Override
            public void run() {
                phaser.arriveAndAwaitAdvance(); //等
                phaser.arriveAndAwaitAdvance();
                phaser.arriveAndAwaitAdvance();
                if (name.equals("新郎") || name.equals("新娘")) {
                    System.out.println(Thread.currentThread().getName() + "开始步入洞房");
                    phaser.arriveAndAwaitAdvance();//
                } else {
                    phaser.arriveAndDeregister();//不是新郎新娘的 下车
                }
            }
        }

        public static void main(String[] args) {
            phaser.bulkRegister(7);//7个人
            for (int i = 0; i < 5; i++) {
                new Thread(new Person("zzz" + i)).start();
            }
            new Thread(new Person("新娘"), "新郎").start();
            new Thread(new Person("新郎"), "新娘").start();
        }
    }

