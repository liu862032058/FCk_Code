package lyq.com.JUC.c1;

import java.util.PriorityQueue;

public class T07_01_PriorityQueque {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();

//        q.add("c");
//        q.add("e");
//        q.add("a");
//        q.add("d");
//        q.add("z");
        for (int i = 0; i < 100; i++) {
            q.add(""+i);
        }


        for (int i = 0; i < 100; i++) {
            System.out.println(q.poll());
        }

    }
}
