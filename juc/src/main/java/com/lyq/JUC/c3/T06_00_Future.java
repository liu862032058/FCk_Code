/**
 * »œ ∂future
 * “Ï≤Ω
 */
package com.lyq.JUC.c3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class T06_00_Future {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		FutureTask<Integer> task = new FutureTask<>(()->{
			TimeUnit.MILLISECONDS.sleep(2000);
			return 1000;
		}); //new Callable () { Integer call();}
		
		new Thread(task).start();

		System.out.println("jj");
		System.out.println(task.get()); //◊Ë»˚

	}
}
