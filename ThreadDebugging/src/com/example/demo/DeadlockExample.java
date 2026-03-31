package com.example.demo;

import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    private static final ReentrantLock lock1=new ReentrantLock();
    private static final ReentrantLock lock2=new ReentrantLock();

    public static void main(String[] args) {
        Runnable task1 = () ->{
            try{
                lock1.lock();
                System.out.println("Thread 1 acquired lock 1");
                Thread.sleep(500L);
                lock2.lock();
                System.out.println("Thread 1 acquired lock 2");
                Thread.sleep(500L);
                lock2.unlock();
                Thread.sleep(500L);
                lock1.unlock();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable task2 = () ->{
            try{
                lock1.lock();
                System.out.println("Thread 2 acquired lock 1");
                Thread.sleep(500L);
                lock2.lock();
                System.out.println("Thread 2 acquired lock 2");
                Thread.sleep(500L);
                lock2.unlock();
                Thread.sleep(500L);
                lock1.unlock();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        };
        Thread thread1=new Thread(task1,"Thread 1");
        Thread thread2=new Thread(task2,"Thread 2");
        thread1.start();
        thread2.start();
    }
}
