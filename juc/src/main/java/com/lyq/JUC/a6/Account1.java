/**
 * �����⣺ģ�������˻�
 * ��ҵ��д��������
 * ��ҵ�������������
 * �����в��У�
 *
 * ���ײ���������⣨dirtyRead��
 */

package com.lyq.JUC.a6;

public class Account1 {
	String name;
	volatile double balance;
	
	public synchronized void set(String name, double balance) {
		this.name = name;

		//�����ӳ�
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		this.balance = balance;
	}
	
	public synchronized double getBalance(String name) {
		return this.balance;
	}
	
	
	public static void main(String[] args) {
		Account1 account1 = new Account1();
		new Thread(()->{account1.set("zs",100.00);}).start();
//		try {
//			TimeUnit.SECONDS.sleep(1);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		System.out.println(account1.getBalance("zs"));

//		try {
//			TimeUnit.SECONDS.sleep(1);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println(account1.getBalance("zs"));

	}
}
