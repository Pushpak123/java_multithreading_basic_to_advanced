package concurrencydesignpatterns;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Worker extends Thread{
    private final BlockingQueue<Runnable>taskQueue;

    public Worker(BlockingDeque<Runnable>taskQueue)
    {
        this.taskQueue=taskQueue;
    }

    @Override
    public void run() {
       while(true)
       {
           try{
               Runnable task=taskQueue.take();
               task.run();
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
               break;
           }
       }
    }
}
