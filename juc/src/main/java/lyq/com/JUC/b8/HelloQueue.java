package lyq.com.JUC.b8;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class HelloQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayBlockingQueue<>(4);
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q);


    }
}
