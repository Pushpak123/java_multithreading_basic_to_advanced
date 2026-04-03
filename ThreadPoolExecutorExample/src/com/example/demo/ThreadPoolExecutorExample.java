package com.example.demo;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor)
                Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            int task = i;
            executor.execute(() -> {
                System.out.println(
                        Thread.currentThread().getName() + " executing task " + task
                );
            });
        }

        executor.shutdown();
    }
}