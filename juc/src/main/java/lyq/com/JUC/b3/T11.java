package lyq.com.JUC.b3;

import java.util.concurrent.Semaphore;

public class T11 {

    public static void main(String[] args) {
        Semaphore s = new Semaphore(4, true);

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    s.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    s.release();
                }

                System.out.println(Thread.currentThread().getName()+"  running...");
            },"t"+i).start();


        }

    }
}
