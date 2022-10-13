public class Property extends Field {

    private final int serieID;
    private Player owner;
    private String option;

    boolean monopoly = false; // bruges i Plot.onLand() til at bestemme om der skal vises tilbud om at bygge

    public Property(int id, String label, int cost, int income, int serieID) {
        super(id, label, cost, income);
        this.serieID = serieID;
        this.owner = null;
    }

    @Override
    public String toString() {
        return super.toString() + " tilhører serie " + getSerieID();
    }

    @Override
    public String onLand(Player p) {
        // TODO: add if the owner == p then you shouldn't pay rent
        String s = super.onLand(p) + "\n";
        if (this.getOwner() == null) {
            option = "buy";
            s += "Vil du købe " + this.getLabel() + " for " + this.getCost() + " kr? Din saldo nu: " + p.getBankAccount().getBalance() + "\nTast J for ja, N for nej.";
        } else {
            option = "payRent";
            s += this.getOwner().getName() + " ejer allerede " + this.getLabel();
            s += "\nDu skal betale " + this.getIncome() + " kr i husleje. Tast J for at acceptere:";
        }
        return s;
    }

    @Override
    protected String onAccept(Player p) {
        String s = "";
        if (option.equalsIgnoreCase("buy")) {
            s = this.getLabel() + " er din!";
            p.buy(this.cost);
            p.addDeed(this);
            setOwner(p);
        } else if (option.equalsIgnoreCase("payRent")) {
            s = "Du har betalt " + this.getIncome()+ " til " + this.owner.getName() + " i husleje.";
            p.pay(this.owner, this.getIncome());
        }
        return s;
    }

    @Override
    protected String onReject(Player p) {
        String s = "";
        if (option.equalsIgnoreCase("buy")) {
            // budrunde
            s = "En budrunde er startet på " + this.getLabel();
        } else if (option.equalsIgnoreCase("payRent")) {
            // forlader spillet
            s = "Du har ikke råd til at betale " + this.owner.getName() + " " + this.getIncome() + " for at lande på " + this.getLabel() + ". Du forlader spillet.";
        }
        return s;
    }


    public int getSerieID() {
        return serieID;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
