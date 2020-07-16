package com.lyq.JUC.b6;

public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
