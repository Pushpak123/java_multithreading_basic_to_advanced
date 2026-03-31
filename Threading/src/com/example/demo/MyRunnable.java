package com.example.demo;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Creating thread with runnable:Thread is running");
    }
}
