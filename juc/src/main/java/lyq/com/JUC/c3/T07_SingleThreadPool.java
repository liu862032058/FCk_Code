package lyq.com.JUC.c3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T07_SingleThreadPool {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newSingleThreadExecutor();
		for(int i=0; i<5; i++) {
			final int j = i;
			service.execute(()->{
				
				System.out.println(j + " " + Thread.currentThread().getName());
			});
		}
		TimeUnit.SECONDS.sleep(2);
		service.shutdown();
		System.out.println(service.isShutdown());
			
	}
}
