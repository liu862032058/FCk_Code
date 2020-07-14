package lyq.com.JUC.b3;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class T81 {
        static Phaser phaser = new MarriagePhaser();

        static class MarriagePhaser extends Phaser { //ʵ��phaser�ӿ�
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                switch (phase) {//�ĸ��׶�
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
                System.out.println("���붴�������" + registeredParties);
                return true;
            }

            private boolean allLeave(int registeredParties) {
                System.out.println("�������뿪" + registeredParties);
                return false;
            }

            private boolean allEat(int registeredParties) {
                System.out.println("�����˳Է�" + registeredParties);
                return false;
            }

            private boolean allArrive(int registeredParties) {
                System.out.println("�����˵���" + registeredParties);
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
                phaser.arriveAndAwaitAdvance(); //��
                phaser.arriveAndAwaitAdvance();
                phaser.arriveAndAwaitAdvance();
                if (name.equals("����") || name.equals("����")) {
                    System.out.println(Thread.currentThread().getName() + "��ʼ���붴��");
                    phaser.arriveAndAwaitAdvance();//
                } else {
                    phaser.arriveAndDeregister();//������������� �³�
                }
            }
        }

        public static void main(String[] args) {
            phaser.bulkRegister(7);//7����
            for (int i = 0; i < 5; i++) {
                new Thread(new Person("zzz" + i)).start();
            }
            new Thread(new Person("����"), "����").start();
            new Thread(new Person("����"), "����").start();
        }
    }

