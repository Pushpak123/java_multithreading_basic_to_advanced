package com.example.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final Lock lock=new ReentrantLock();
    private int counter=0;

    public void increment()
    {
        lock.lock();
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + " counter: " + counter);
        }finally {
            lock.unlock();

        }
    }
}
