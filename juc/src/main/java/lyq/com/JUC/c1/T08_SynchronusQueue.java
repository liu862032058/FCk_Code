package lyq.com.JUC.c1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class T08_SynchronusQueue { //����Ϊ0
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> strs = new SynchronousQueue<>();
		
		new Thread(()->{
			try {
				while (true)
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();


//		strs.put("aaa"); //�����ȴ�����������
//
//		strs.put("bbb");
//		strs.add("ff");
		System.out.println(strs.size());
	}
}
