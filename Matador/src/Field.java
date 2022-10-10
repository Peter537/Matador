/* TODO: Make this class a super class by...
    1. removing attributes that are not common to ALL field types (cost, income, seriesID, owner)
    2. adding onLand, onReject and processResonse methods
*
*
* */
public class Field {

    protected String label;
    protected int id;
    protected int cost;
    protected int income;

    public Field(int id, String label, int cost, int income, int seriesID) {
        this.label = label;
        this.id = id;
        this.cost = cost;
        this.income = income;
        //this.seriesID = seriesID;
    }

    public Field(int id, String label, int cost, int income) {
        this.label = label;
        this.id = id;
        this.cost = cost;
        this.income = income;
    }

    protected String getLabel() {
        return this.label;
    }

    public int getID() {
        return id;
    }

    public String onLand(Player p) {
        return p.getName() + " er landet på " + this;
    }

    @Override
    public String toString() {
        return id + ": " + label;
    }

    public void processChoice(String choice, Player p) {
        if (choice.equalsIgnoreCase("J")) {
            onAccept(p);
        } else {
            onReject(p);
        }
    }

    protected String onAccept(Player p) {
        return "";
    }

    protected String onReject(Player p) {
        return "";
    }
}