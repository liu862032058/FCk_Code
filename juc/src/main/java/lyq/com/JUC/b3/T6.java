package lyq.com.JUC.b3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T6 {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        System.out.println("���߳̿�ʼִ�С��� ����");
        //��һ�����߳�ִ��
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        es1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("���̣߳�"+Thread.currentThread().getName()+"ִ��");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        });
        es1.shutdown();

        //�ڶ������߳�ִ��
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        es2.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("���̣߳�"+Thread.currentThread().getName()+"ִ��");
                latch.countDown();
            }
        });
        es2.shutdown();
        System.out.println("�ȴ������߳�ִ����ϡ��� ����");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("�������̶߳�ִ����ϣ�����ִ�����߳�");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("���߳�ִ�����");
    }
}

