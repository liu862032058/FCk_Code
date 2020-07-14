package lyq.com.JUC.a2;
/**
 * synchronized关键字
 * 对某个对象加锁
 * @author mashibing
 */


public class T1 {

    private int count = 10;
    private Object o = new Object();

    public void m (){
        synchronized (o){
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public void m1 (){
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }



}
