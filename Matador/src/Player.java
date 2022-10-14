import java.util.ArrayList;

public class Player {

    private final String name;
    private final BankAccount bankAccount;
    private int position = 1;
    private final ArrayList<Property> deeds = new ArrayList<>();

    public Player(String name, int amount) {
        this.name = name;
        this.bankAccount = new BankAccount(amount);
    }

    /*TODO: udvid metoden sådan at den tager en instans af type Property. Denne instans skal lægges i deeds */
    public void buy(int cost) {
        //add deed to deeds
        bankAccount.doTransaction(-cost);
    }

    public void buy(Property property) {
        bankAccount.doTransaction(-property.getCost());
        addDeed(property);
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

    public int updatePosition(int diceValue) {
        position += diceValue;
        if (position > 40) {
            position -= 40;
            //this.receive(board.getField(1).getIncome()); // Pseudokode for hvor mange penge man får
            //bankAccount.doTransaction(4000);
        }
        return position;
    }

    public void addDeed(Property property) {
        deeds.add(property);
    }

    public int getPropertyValues() {
        int propertyValues = 0;
        for (Property property : deeds) {
            propertyValues += property.getCost();
        }
        return propertyValues;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + getName() + '\'' +
                ", bankAccount=" + getBankAccount() +
                '}';
    }
}