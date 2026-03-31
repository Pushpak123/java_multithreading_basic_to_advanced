package com.example.demo;

public class ThreadSafeCounter {
    private int counter=0;
    public synchronized void increment()
    {
        counter++;
        System.out.println(Thread.currentThread().getName()+" incremented the counter to "+counter);
    }
    public int getCounter()
    {
        return counter;
    }
}
