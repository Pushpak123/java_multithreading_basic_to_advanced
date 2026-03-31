package concurrencydesignpatterns;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
    private final BlockingQueue<Integer>queue;

    public Consumer(BlockingQueue<Integer>queue)
    {
        this.queue=queue;
    }

    @Override
    public void run() {
        try{
            while (true)
            {
                int value=queue.take();
                if(value==-1)
                {
                    break;
                }
                System.out.println("Consumed: "+value);
                TimeUnit.MILLISECONDS.sleep(500L);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
