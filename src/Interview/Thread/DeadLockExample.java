package Interview.Thread;

public class DeadLockExample {
    public static void main(String[] args) {
        //Bu misalda, hər iki thread bir-birinin saxladığı resursu gözlədiyi üçün deadlock vəziyyəti yaranır.
        final Object resource1 = "Resurs 1";
        final Object resource2 = "Resurs 2";

        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Interview.Thread 1 resurs 1-i tutub.");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (resource2) {
                    System.out.println("Interview.Thread 1 resurs 2-ni tutdu.");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Interview.Thread 2 resurs 2-ni tutub.");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (resource1) {
                    System.out.println("Interview.Thread 2 resurs 1-i tutdu.");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
