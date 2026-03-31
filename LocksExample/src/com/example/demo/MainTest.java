package com.example.demo;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockExample reentrantLock=new ReentrantLockExample();
        Thread t1=new Thread(reentrantLock::increment,"Thread 1");
        Thread t2=new Thread(reentrantLock::increment,"Thread 2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
