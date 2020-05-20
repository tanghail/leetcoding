package com.thl.test.threadPool;

import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Callable<Object>() {
            public Object call() throws Exception {
                System.out.println("hello world");
                return true;
            }
        });
    }
}
