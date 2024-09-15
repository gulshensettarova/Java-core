package Thread.LockMechanisms;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    private static final int NUM_THREADS = 3; // Nə qədər thread olacağını müəyyən edir

    public static void main(String[] args) {
        // CyclicBarrier obyektini yaradaraq, barrier nöqtəsi üçün müəyyən sayda thread tələb edir
        CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS, () -> {
            System.out.println("Barrier keçildi! Bütün thread-lər hazırdır.");
        });

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " iş görür...");
                Thread.sleep((int) (Math.random() * 1000)); // Simulyasiya etmək üçün gecikmə
                System.out.println(Thread.currentThread().getName() + " barrier nöqtəsinə çatdı.");

                // Barrier nöqtəsinə çatmaq üçün gözləyir
                barrier.await();

                System.out.println(Thread.currentThread().getName() + " barrieri keçdi.");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        // Thread-lərin yaradılması və başlaması
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
