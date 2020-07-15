package com.lyq.JUC.b3.t11;

import java.util.concurrent.Semaphore;

public class T111 {
    public static void main(String[] args) {

        Semaphore sp = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Students(sp,"Ñ§Éú"+i).start();
        }


    }
}
