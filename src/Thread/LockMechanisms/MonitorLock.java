package Thread.LockMechanisms;

public class MonitorLock {
    private int balance = 1000;

    //Qeyd : burada lock obyekti əvəzinə this-də istifadə oluna bilər( synchronized(lock)--> synchronized(this)
    //Əgər this yoxda öz yaratdigimiz metod istifade edirikse butun metodlarin eyni obyekt ile lock-landigina diqqet etmek lazimdir
    private final Object lock = new Object();

    // Sinxronizasiya olunmuş metod
    public void deposit(int amount) {
        synchronized(lock) {  // Eyni lock obyekti ilə sinxronizasiya
            balance += amount;
        }
    }
    // Sinxronizasiya olunmuş blok
    public void withdraw(int amount) {
        synchronized(lock) {  // Bu obyektin monitor kilidini əldə edir
            balance -= amount;
        }
    }

    public int getBalance() {
        return balance;
    }

        public static void main(String[] args) throws InterruptedException {
            MonitorLock account = new MonitorLock();

            Runnable depositTask = () -> {
                for (int i = 0; i < 1000; i++) {
                    account.deposit(2);
                }
            };

            Runnable withdrawTask = () -> {
                for (int i = 0; i < 1000; i++) {
                    account.withdraw(1);
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
