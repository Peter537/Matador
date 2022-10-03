

public class Player {
    String name;
    int amount;

    public Player(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public Player(String name) {
        this.name = name;
        this.amount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}