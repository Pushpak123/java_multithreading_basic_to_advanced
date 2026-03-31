package com.example.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapExample {
    public static void main(String[] args) throws InterruptedException {
        Map<String,String>taskResult=new ConcurrentHashMap<>();
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        for(int i=0;i<6;i++) {
            String taskName = "Task " + i;
            executorService.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " is executing " + taskName);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                taskResult.put(taskName, "Completed by: " + threadName);
            });
        }
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
            System.out.println("task result:");
            taskResult.forEach((task,result)->{
                System.out.println(task +": "+result);
            });
        }
    }
