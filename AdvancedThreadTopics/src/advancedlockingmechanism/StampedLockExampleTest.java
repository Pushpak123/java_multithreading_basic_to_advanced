package advancedlockingmechanism;

public class StampedLockExampleTest {
    public static void main(String[] args) {
        BankAccount account=new BankAccount();

        Runnable depositTask=()->{
            for(int i=0;i<3;i++)
            {
                account.deposit(100);
            }
            try{
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable withdrawTask = () ->{
            for(int i=0;i<3;i++)
            {
                account.withdraw(50);
            }
            try{
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable readTask = () ->{
            for(int i=0;i<3;i++)
            {
                account.getBalanceOptimistic();
            }
            try{
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread depositerThread=new Thread(depositTask,"Depositor");
        Thread withdrawerThread=new Thread(withdrawTask,"Withdrawer");
        Thread readerThread=new Thread(readTask,"Reader");

        depositerThread.start();
        withdrawerThread.start();
        readerThread.start();

        try{
            depositerThread.join();
            withdrawerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Final balance: "+account.getBalance());
    }
}
