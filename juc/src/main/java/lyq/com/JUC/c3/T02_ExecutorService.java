/**
 * ��ʶExecutorService,�Ķ�API�ĵ�
 * ��ʶsubmit��������չ��execute����������һ������ֵ
 */
package lyq.com.JUC.c3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T02_ExecutorService  {
    public static void main(String[] args) {
//        ExecutorService e = Executors.newCachedThreadPool();
        ExecutorService e = Executors.newFixedThreadPool(2);

    }
}
