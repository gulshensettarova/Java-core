package Thread.LockMechanisms;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiLockExample {
    private int balance = 1000;

    private final Lock depositLock = new ReentrantLock();
    private final Lock withdrawLock = new ReentrantLock();

    public void performTransactions(int depositAmount, int withdrawAmount) {
        // İlk lock əldə edilir
        depositLock.lock();
        try {
            // Birinci lock-un istifadə olunduğu bölmə
            balance += depositAmount;
            System.out.println("Deposited: " + depositAmount + " | Balance: " + balance);

            // İkinci lock əldə edilir
            withdrawLock.lock();
            try {
                // İkinci lock-un istifadə olunduğu bölmə
                balance -= withdrawAmount;
                System.out.println("Withdrew: " + withdrawAmount + " | Balance: " + balance);
            } finally {
                // İkinci lock-un azad edilməsi
                withdrawLock.unlock();
            }
        } finally {
            // Birinci lock-un azad edilməsi
            depositLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MultiLockExample account = new MultiLockExample();

        Runnable task1 = () -> account.performTransactions(100, 50);
        Runnable task2 = () -> account.performTransactions(200, 150);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final balance: " + account.balance);
    }
}
