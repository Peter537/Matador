public class BankAccount {

    private int balance;

    public BankAccount(int startAmount) {
        this.balance = startAmount;
    }

    public void doTransaction(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + getBalance() +
                '}';
    }
}