public class Player {

    private final String name;
    private final BankAccount bankAccount;
    private int position = 1;

    public Player(String name, int amount) {
        this.name = name;
        this.bankAccount = new BankAccount(amount);
    }

    public void buy(int cost) {
        bankAccount.doTransaction(-cost);
    }

    public void pay(int amount) {
        bankAccount.doTransaction(-amount);
    }

    public String getName() {
        return name;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public int getPosition() {
        return position;
    }

    public int updatePosition(int diceValue) {
        position += diceValue;
        if (position > 40) {
            position -= 40;
            //bankAccount.doTransaction(4000);
        }
        return position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + getName() + '\'' +
                ", bankAccount=" + getBankAccount() +
                '}';
    }
}