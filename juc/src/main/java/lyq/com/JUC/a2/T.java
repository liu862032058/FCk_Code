/**
 * synchronized�ؼ���
 * ��ĳ���������
 * @author mashibing
 */

package lyq.com.JUC.a2;

public class T {
	
	private volatile int count = 10;
	private Object o = new Object();
	
	public void m() {
		synchronized(o) { //�κ��߳�Ҫִ������Ĵ��룬�������õ�o����

			System.out.println(Thread.currentThread().getName() + " count = " + count);
			if (count==0){
				return ;
			}else {
				count--;
			}
		}
	}

	public static void main(String[] args) {
		T t =new T();






//		new Thread(()->{
//			for (int i = 0; i < 10; i++) {
//				t.m();
//			}
//		}).start();
//		new Thread(()->{
//			for (int i = 0; i < 10; i++) {
//				t.m();
//			}
//		}).start();

	}


}

