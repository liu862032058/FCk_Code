/**
 * 对比上面一个小程序，分析一下这个程序的输出
 * @author mashibing
 */

package lyq.com.JUC.a4;

public class T implements Runnable {

	private volatile  int count = 10;
	
	public synchronized void run() { 
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	
	public static void main(String[] args) {

		T t = new T();
		for(int i=0; i<5; i++) {
			new Thread(t, "THREAD" + i).start();
		}
	}
	
}
