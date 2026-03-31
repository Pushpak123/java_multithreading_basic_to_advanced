package com.example.demo;

public class MyTest {
    public static void main(String[] args) {
//        MyThread myThread=new MyThread();
//        myThread.start();
//        System.out.println("Thread is started");
        MyRunnable myRunnable=new MyRunnable();
        Thread myThread=new Thread(myRunnable);
        myThread.start();
        System.out.println("Thread is started");
    }
}
