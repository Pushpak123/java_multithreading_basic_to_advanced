package exceptionhandlinginthreads;


import java.util.concurrent.*;

public class CallableExceptionExample {
    public static void main(String[] args) {
        while (true)
        {
            ExecutorService executor= Executors.newSingleThreadExecutor();
            Callable<String>task=()->{
                System.out.println(Thread.currentThread().getName()+": Task Started.");
                double value=Math.random();
                System.out.println("Generated number of thread: "+Thread.currentThread().getName()+" is "+value);
                if(value>0.5)
                {
                    throw new RuntimeException("Simulated error");
                }
                Thread.sleep(1000L);
                return (Thread.currentThread().getName()+" Task completed successfully. ");
            };
            Future<String>future=executor.submit(task);

            try{
                String result= future.get();
                System.out.println("Result: "+result);

            } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
                System.out.println("Task Interrupted");

            } catch (ExecutionException e) {
                System.out.println("Task failed with execution: " + e.getCause().getMessage());
                break;
            }finally {
                executor.shutdown();
            }
        }
    }
}
