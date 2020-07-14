package lyq.com.JUC.b4;

import java.util.LinkedList;

public class M1<T> {

    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10; //最多10个元素
    private int count = 0;

    //
    public synchronized void put(T t){
        while (lists.size()==MAX){
            try {
                this.wait(); //effective java
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(t);
        count ++;
        this.notifyAll();//通知消费者线程进行消费
    }

    public synchronized T get(){

        T t = null;
        while (lists.size()==0){
            try {
                this.wait(); //effective java
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.removeFirst();
        count--;
        this.notifyAll();//通知生产者进行生产
        return t;
    }

    public static void main(String[] args) {

    }


}
