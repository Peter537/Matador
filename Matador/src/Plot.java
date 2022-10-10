public class Plot extends Field {

    private final int seriesID;
    private Player owner;
    private String option;

    public Plot(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income);
        this.seriesID = seriesID;
    }

    @Override
    public String toString() {
        return super.toString() + " tilhører serie " + seriesID;
    }

    @Override
    public String onLand(Player p) {
        String s = super.onLand(p) + "\n";
        if (this.owner == null) {
            option = "buy";
            s += "Vil du købe " + this.getLabel() + "? Tast J for ja, N for nej.";
        } /*else {
            s += "Du skal betale " + this.owner.getName() + " " + this.income + " for at lande på " + this.getLabel();
        }*/
        return s;
    }

    @Override
    protected String onAccept(Player p) {
        String s = "";
        if (option.equalsIgnoreCase("buy")) {
            s = "Grunden er din!";
            p.buy(this.cost);
        }
        return s;
    }

    @Override
    protected String onReject(Player p) {
        return "";
    }
}