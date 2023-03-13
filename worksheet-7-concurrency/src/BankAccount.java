public class BankAccount {
    private int balance = 0;

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int money) {
        balance = balance + money;
    }

    public synchronized int retrieve(int money) {
        int result = balance > money
            ? money
            : balance;

        balance = balance - result;
        return result;
    }
}
