
public class ThreadDeposit extends Thread {
    private Bank bank;
    private String name;
    private double amount;

    public ThreadDeposit(Bank bank, String name, double amount) {
        this.bank = bank;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void run() {
        bank.deposit(amount);
    }
}
