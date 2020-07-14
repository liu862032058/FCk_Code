package lyq.com.JUC.a3;

public class T1 {
    private /*volatile*/ int count = 100;

    //    public synchronized void m() {
//        count--;
//        System.out.println(Thread.currentThread().getName() + " count = " + count);
//    }
    public synchronized void m2() {
        count ++;
        System.out.println("hhh count = " + count);
    }
    public static void main(String[] args) {
        T t = new T();
        for(int i=0; i<100; i++) {
            new Thread(t, "" + i).start();
        }
//        new Thread(t).start();
    }
}
