package com.example.demo;

public class VolatileExample {
    private volatile boolean runnning=true;
    public void stopRunning()
    {
        runnning=false;
    }
    public void run()
    {
        while (runnning)
        {
            System.out.println("Thread is running");
        }
        System.out.println("Thread is stopped");
    }
}
