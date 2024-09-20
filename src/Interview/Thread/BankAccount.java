package Interview.Thread;

public class BankAccount {
    private int balance;

    public BankAccount(int balanceç) {
        this.balance = balance;
    }

    public synchronized void transfer(String customerName,int amount) {
        if(balance >= amount) {
            System.err.println(customerName+ "is transferring  " + amount+ "units.");
            try {
                Thread.sleep(1000); //simulyasiya məqsədli gecikmə
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(customerName + " completed transfer. New balance: " + balance);
        }
        else {
            System.out.println(customerName + " transfer failed. Insufficient balance.");
        }

    }
}
