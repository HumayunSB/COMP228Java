
public class DriverMain {
    public static void main(String[] args) {
        Bank bank = new Bank(500.00); // Initial balance
        System.out.println("Initial balance: " + bank.getBalance()); // Display initial balance

        // Create threads for withdrawals first
        ThreadWithdrawal t1 = new ThreadWithdrawal(bank, "dummy1", 100);
        ThreadWithdrawal t2 = new ThreadWithdrawal(bank, "dummy2", 100);
        ThreadWithdrawal t3 = new ThreadWithdrawal(bank, "dummy3", 100);
        ThreadWithdrawal t4 = new ThreadWithdrawal(bank, "dummy4", 100);

        // Start withdrawal threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all withdrawal threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Create threads for deposits
        ThreadDeposit d1 = new ThreadDeposit(bank, "dummy1", 50);
        ThreadDeposit d2 = new ThreadDeposit(bank, "dummy2", 50);
        ThreadDeposit d3 = new ThreadDeposit(bank, "dummy3", 50);
        ThreadDeposit d4 = new ThreadDeposit(bank, "dummy4", 50);

        // Start deposit threads
        d1.start();
        d2.start();
        d3.start();
        d4.start();

        // Wait for all deposit threads to finish
        try {
            d1.join();
            d2.join();
            d3.join();
            d4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}