/**
 * 认识Executor
 */
package lyq.com.JUC.c3;

import java.util.concurrent.Executor;

public class T01_MyExecutor
		implements Executor
{

	public static void main(String[] args) {
		new T01_MyExecutor().execute(()->System.out.println("hello executor"));
		new T01_MyExecutor().execute(()->{
			System.out.println("hhhh");
		});
		new T01_MyExecutor().execute(new Thread(()-> System.out.println("jjj")));
	}

	@Override
	public void execute(Runnable command) {
		//new Thread(command).run();
		command.run();
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
	}

}

