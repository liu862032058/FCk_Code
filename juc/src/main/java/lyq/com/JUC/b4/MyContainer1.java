/**
 * �����⣺дһ���̶�����ͬ��������ӵ��put��get�������Լ�getCount������
 * �ܹ�֧��2���������߳��Լ�10���������̵߳���������
 * 
 * ʹ��wait��notify/notifyAll��ʵ��
 * 
 */
package lyq.com.JUC.b4;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class MyContainer1<T> {
	final private LinkedList<T> lists = new LinkedList<>();
	final private int MAX = 10; //���10��Ԫ��
	private int count = 0;
	
	
	public synchronized void put(T t) {
		while(lists.size() == MAX) { //����Ϊʲô��while��������if��
			try {
				this.wait(); //effective java
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		lists.add(t);
		++count;
		this.notifyAll(); //֪ͨ�������߳̽�������
	}
	
	public synchronized T get() {
		T t = null;
		while(lists.size() == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		t = lists.removeFirst();
		count --;
		this.notifyAll(); //֪ͨ�����߽�������
		return t;
	}
	
	public static void main(String[] args) {
		MyContainer1<String> c = new MyContainer1<>();
		System.out.println("�����������߳�");
		//�����������߳�
		for(int i=0; i<2; i++) {
			new Thread(()->{
				for(int j=0; j<10; j++) System.out.println(c.get());
			}, "c" + i).start();
		}
		System.out.println("�������߳��������");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		�����������߳�
		for(int i=0; i<2; i++) {
			new Thread(()->{
				for(int j=0; j<10; j++) c.put(Thread.currentThread().getName() + "---�� " + j);
			}, "p" + i).start();
		}
	}
}
