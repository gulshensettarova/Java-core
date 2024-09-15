package Thread.LockMechanisms;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private int balance = 1000;

    // ReentrantLock obyektini yaradırıq
    private final Lock lock = new ReentrantLock();

    // Kilidi əldə edir və balansı artırır
    public void deposit(int amount) {
        lock.lock();  // Kilidi əldə et
        try {
            balance += amount;  // Balansı artır
        } finally {
            lock.unlock();  // Kilidi azad et
        }
    }

    // Kilidi əldə edir və balansı azaldır
    public void withdraw(int amount) {
        lock.lock();  // Kilidi əldə et
        try {
            balance -= amount;  // Balansı azaldır
        } finally {
            lock.unlock();  // Kilidi azad et
        }
    }

    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) throws InterruptedException {
        MonitorLock account = new MonitorLock();

        Runnable depositTask = () -> {
            for (int i = 0; i < 1000; i++) {
                account.deposit(2);  // Balansı artır
            }
        };

        Runnable withdrawTask = () -> {
            for (int i = 0; i < 1000; i++) {
                account.withdraw(1);  // Balansı azaldır
            }
        };

        Thread thread1 = new Thread(depositTask);
        Thread thread2 = new Thread(withdrawTask);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final balance: " + account.getBalance());
    }
}
