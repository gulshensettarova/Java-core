package Interview.Thread;

public class TransferTask extends Thread{
    private BankAccount account;
    private String customerName;
    private int amount;

    public TransferTask(BankAccount account, String customerName, int amount) {
        this.account = account;
        this.customerName = customerName;
        this.amount = amount;
    }
    public void run() {
        account.transfer(customerName, amount);
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount(500);  // 500AZN balansı olan hesab

        TransferTask customer1 = new TransferTask(account, "Customer 1", 30);
        TransferTask customer2 = new TransferTask(account, "Customer 2", 50);
        TransferTask customer3 = new TransferTask(account, "Customer 3", 30);

        customer1.start();
        customer2.start();
        customer3.start();
    }
}
