package com.example.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedQueue {
    Queue<Integer>queue=new LinkedList<>();
    private final int capacity=5;

    private final ReentrantLock lock=new ReentrantLock();
    private final Condition notFull= lock.newCondition();
    private final Condition notEmpty=lock.newCondition();

    public void produce(int value) throws InterruptedException {
        lock.lock();
        try{
        while(queue.size() == capacity)
        {
            System.out.println("Queue is full.Producer is waiting ... ");
            notFull.await();
        }
        queue.add(value);
        System.out.println("Produced: "+value);
        notEmpty.signal();
    }finally {
            lock.unlock();
        }
        }
public void consume() throws InterruptedException {
    lock.lock();
    try{
        while(queue.isEmpty())
        {
            System.out.println("Queue is empty.Consumer is waiting...");
            notEmpty.await();
        }
        int value=queue.poll();
        System.out.println("Consumed: "+value);
        notFull.signal();
    }finally {
        lock.unlock();
    }
}
}
