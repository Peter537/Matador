public class Field {

    private final String label;
    private final int ID;
    private final int cost;
    private final int income;
    private final int seriesID;
    private Player owner;

    public Field(int ID, String label, int cost, int income, int seriesID, Player owner) {
        this.label = label;
        this.ID = ID;
        this.cost = cost;
        this.income = income;
        this.seriesID = seriesID;
        this.owner = owner;
    }

    public String onLand() {
        return "Du er landet på " + ID + " " + label;
    }

    public String getLabel() {
        return label;
    }

    public int getID() {
        return ID;
    }

    public int getCost() {
        return cost;
    }

    public int getIncome() {
        return income;
    }

    public int getSeriesID() {
        return seriesID;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Field{" +
                "ID='" + ID + '\'' +
                ", label=" + label +
                '}';
    }
}