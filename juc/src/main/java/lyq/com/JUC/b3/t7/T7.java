package lyq.com.JUC.b3.t7;

import javafx.concurrent.Worker;

import java.util.concurrent.CountDownLatch;

public class T7 {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);

        Woker w1 = new Woker(latch,"����");
        Woker w2 = new Woker(latch,"����");
        Woker w3 = new Woker(latch,"����");
        Boss boss = new Boss(latch);

            new Thread(w1).start();
            new Thread(w2).start();
            new Thread(w3).start();
            new Thread(boss).start();




    }
}
