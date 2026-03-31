package com.example.demo;

public class MainTest1 {
    //producer consumer example with lock
    public static void main(String[] args) {


        SharedBufferWithLock sharedBufferWithLock = new SharedBufferWithLock();
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedBufferWithLock.produce(i);
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Producer Thread");

        //consumer
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedBufferWithLock.consume();
                try {
                    Thread.sleep(800L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Consumer Thread");
        producer.start();
        consumer.start();

    }
}


