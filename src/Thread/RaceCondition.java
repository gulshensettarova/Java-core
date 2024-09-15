package Thread;

public class RaceCondition {
    private int balance;

    public RaceCondition(int initialBalance) {
        this.balance = initialBalance;
    }

    // Hesabın balansını əldə etmək
    public int getBalance() {
        return balance;
    }

    // Hesaba pul əlavə etmək
    public void deposit(int amount) {
        balance += amount;
    }

    // Hesabdan pul çıxarmaq
    public void withdraw(int amount) {
        balance -= amount;
    }

    public static void main(String[] args) {
        RaceCondition account = new RaceCondition(1000);

         Runnable depositTask=()->{
             for (int i = 0; i < 1000; i++) {
                 account.deposit(1);
             }
         };
        Runnable withdrawTask = () -> {
            for (int i = 0; i < 1000; i++) {
                account.withdraw(1);
            }
        };

        Thread customer1 = new Thread(depositTask);
        Thread customer2 = new Thread(withdrawTask);

        customer1.start();
        customer2.start();

        try {
            customer1.join();
            customer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final balance: " + account.getBalance());

    }
}
