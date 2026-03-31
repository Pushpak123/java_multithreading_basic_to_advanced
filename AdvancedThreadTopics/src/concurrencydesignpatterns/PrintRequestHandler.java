package concurrencydesignpatterns;

public class PrintRequestHandler implements Runnable{
    private final String message;

    public PrintRequestHandler(String message)
    {
        this.message=message;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Processing: "+message);
        try{
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName()+" Completed: "+message);

    }
}
