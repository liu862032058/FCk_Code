/**
 * synchronized关键字
 * 对某个对象加锁
 * @author mashibing
 */

package lyq.com.JUC.a2;

public class T {
	
	private volatile int count = 10;
	private Object o = new Object();
	
	public void m() {
		synchronized(o) { //任何线程要执行下面的代码，必须先拿到o的锁

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

