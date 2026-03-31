package exceptionhandlinginthreads;

public class UncaughtExceptionHandlerExample {
    public static void main(String[] args) {
        Thread.UncaughtExceptionHandler handler = (t, e) -> {
            System.out.println(" Thread: " + t.getName() + " terminated with exception: " + e.getMessage());
        };
        Runnable task = () -> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": Task Started. ");
                    double value = Math.random();
                    System.out.println("Generated number of thread: " + Thread.currentThread().getName() + " is " + value);
                    if (value > 0.5) {
                        throw new RuntimeException("Simulated error");
                    }
                    Thread.sleep(1000L);
                    System.out.println(Thread.currentThread().getName() + ": Task completed successfully.");


                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName() + ": Caught exception." + e.getMessage());
                    break;
                }
            }
        };
        Thread t1 = new Thread(task, "Thread-1");
        t1.setUncaughtExceptionHandler(handler);
        Thread t2 = new Thread(task, "Thread-2");
        t2.setUncaughtExceptionHandler(handler);
        t1.start();
        t2.start();
    }
}