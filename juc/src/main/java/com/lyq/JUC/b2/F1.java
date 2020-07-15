/**
 * synchronized�Ż�
 * ͬ��������е����Խ��Խ��
 * �Ƚ�m1��m2
 * @author mashibing
 */
package com.lyq.JUC.b2;

import java.util.concurrent.TimeUnit;


public class F1 {

    int count = 0;

    synchronized void m1() {
        //do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //ҵ���߼���ֻ�����������Ҫsync����ʱ��Ӧ�ø�������������
        count ++;
        System.out.println(Thread.currentThread().getName()+" �� "+count);

        //do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void m2() {
        //do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //ҵ���߼���ֻ�����������Ҫsync����ʱ��Ӧ�ø�������������
        //����ϸ���ȵ���������ʹ�߳�����ʱ���̣��Ӷ����Ч��
        synchronized(this) {
            count ++;
        }
        //do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        FineCoarseLock  f= new FineCoarseLock();

        for (int i = 0; i < 10; i++) {
            new Thread(f::m1,"t"+i).start();
        }
    }


}

