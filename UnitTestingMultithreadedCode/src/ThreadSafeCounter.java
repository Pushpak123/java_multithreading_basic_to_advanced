import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeCounter {

    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        counter++;
        lock.unlock();
    }

    public int getCounter(){
        lock.lock();
        try {
            return counter;
        }finally {
            lock.unlock();
        }

    }

}
