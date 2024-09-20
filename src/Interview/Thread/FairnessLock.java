package Interview.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLock {

    // Fair lock (true means fair)
    private static final Lock fairLock = new ReentrantLock(true);

    // Unfair lock (false means unfair, default behavior)
    private static final Lock unfairLock = new ReentrantLock(false);

    public static void main(String[] args) {
        // Thread-ləri fair və unfair kilidlər üzərində yaradırıq
        System.out.println("fairness lock:");
        executeThreads(fairLock);   // Fair Lock test

        System.out.println("unFair lock:");
        executeThreads(unfairLock); // Unfair Lock test
    }

    // Thread-ləri işə salmaq üçün metod
    private static void executeThreads(Lock lock) {
        for (int i = 1; i <= 5; i++) {
            final int threadId = i;
            new Thread(() -> accessResource(threadId, lock)).start();
        }
    }

    // Kilid tələb edən resursa giriş
    private static void accessResource(int threadId, Lock lock) {
        System.out.println("Thread " + threadId + " kilidi almağa çalışır...");
        lock.lock(); // Kilidi əldə etməyə çalışırıq
        try {
            System.out.println("Thread " + threadId + " kilidi əldə etdi və resursu istifadə edir.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            System.out.println("Thread " + threadId + " kilidi buraxır.");
            lock.unlock(); // Kilidi buraxırıq
        }
    }
}
