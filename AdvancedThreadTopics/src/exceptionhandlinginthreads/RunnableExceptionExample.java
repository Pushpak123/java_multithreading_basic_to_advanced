package exceptionhandlinginthreads;

public class RunnableExceptionExample {
    public static void main(String[] args) {
        Runnable task = () ->{
            while (true)
            {
                try{
                    System.out.println(Thread.currentThread().getName()+" Task started. ");
                    double value=Math.random();
                    System.out.println("Generated number for thread: "+Thread.currentThread().getName()+" is "+value);
                    if(value>0.5) {
                        throw new RuntimeException("Simulated error");
                    }
                    Thread.sleep(1000L);
                    System.out.println(Thread.currentThread().getName()+": Task completed successfully. ");
                    } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName()+": Caught Exception: "+e.getMessage() );
                    break;
                }
            }
            };
        Thread thread1=new Thread(task,"Thread-1");
        Thread thread2=new Thread(task,"Thread-2");
        thread1.start();
        thread2.start();

        }
    }


