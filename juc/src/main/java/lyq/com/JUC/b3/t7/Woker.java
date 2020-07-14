package lyq.com.JUC.b3.t7;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Woker implements Runnable {

    private CountDownLatch countDownLatch;
    private String name;



    public Woker(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        this.dowork();
        try{
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        }catch(InterruptedException ie){
        }
        System.out.println(this.name + "活干完了！");
        this.countDownLatch.countDown();

    }

    public void dowork(){
        System.out.println("正在干活");
    }
}
