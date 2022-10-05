public class Field {

    private final int ID;
    private final String label;
    private final int cost;
    private final int income;
    private final int seriesID;
    private final Player owner;

    public Field(int ID, String label, int cost, int income, int seriesID, Player owner) {
        this.ID = ID;
        this.label = label;
        this.cost = cost;
        this.income = income;
        this.seriesID = seriesID;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Field{" +
                "ID=" + ID +
                ", label='" + label + '\'' +
                ", cost=" + cost +
                ", income=" + income +
                ", seriesID=" + seriesID +
                ", owner=" + owner +
                '}';
    }
}
