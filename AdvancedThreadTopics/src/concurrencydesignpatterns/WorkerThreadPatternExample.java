package concurrencydesignpatterns;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class WorkerThreadPatternExample {
    public static void main(String[] args) {
        BlockingDeque<Runnable>taskQueue=new LinkedBlockingDeque<>();
        int numberOfWorkers=3;
        Worker[]workers=new Worker[numberOfWorkers];

        for(int i=0;i<numberOfWorkers;i++)
        {
            workers[i]=new Worker(taskQueue);
            workers[i].start();
        }

        for(int i=1;i<=10;i++)
        {
            taskQueue.add(new Task(i));
        }
        try{
            Thread.sleep(12000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        for(Worker worker:workers)
        {
         worker.interrupt();
        }
    }
}
