package com.example.demo;

public class MainTest1 {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockExample readWriteLock=new ReadWriteLockExample();
        Thread writeThread=new Thread(()->readWriteLock.writeData(49),"Write Thread");
        Thread reader1=new Thread(readWriteLock::readData,"Reader 1");
        Thread reader2=new Thread(readWriteLock::readData,"Reader 2");

        writeThread.start();
        reader1.start();
        reader2.start();

        writeThread.join();
        reader1.join();
        reader2.join();


    }
}
