package lyq.com.JUC.b4;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class M2<T> {

    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10; //最多10个元素
    private int count = 0;
    private  ReentrantLock r=new ReentrantLock();
    private Condition consumer =r.newCondition();
    private Condition productor =r.newCondition();



    public void put(T t){
        try {
            r.lock();

        } finally {
            r.unlock();
        }
    }
    public T get(){
        T t =null;


        return t;
    }

}
