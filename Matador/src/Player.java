import java.util.ArrayList;

public class Player {

    private final String name;
    private final BankAccount bankAccount;
    private int position = 1;
    private final ArrayList<Field> deeds = new ArrayList<>();


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

    public void pay(Player p, int amount) {
        bankAccount.doTransaction(-amount);
        p.getBankAccount().doTransaction(amount);
    }

    public void receive(int amount) {
        bankAccount.doTransaction(amount);
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

    public void addDeed(Field field) {
        deeds.add(field);
    }

    public int updatePosition(int diceValue) {
        position += diceValue;
        if (position > 40) {
            position -= 40;
            //this.receive(board.getField(1).getIncome()); // Pseudokode for hvor mange penge man får
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