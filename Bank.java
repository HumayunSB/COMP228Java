
public class Bank {
    private double balance;

    public Bank(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit: " + amount);
        System.out.println("Current balance: " + balance);
    }

    public synchronized void withdraw(double amount, String name) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(name + " withdrew: " + amount);
            System.out.println("Current balance: " + balance);
        } else {
            System.out.println(name + " cannot withdraw " + amount + ". Insufficient balance.");
        }
    }

    // Getter for balance
    public synchronized double getBalance() {
        return balance;
    }
}