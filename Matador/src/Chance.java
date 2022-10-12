public class Chance extends Field {
    public Chance(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }

    @Override
    public String onLand(Player p) {
        String s = super.onLand(p);
        s+= "\n Træk et kort fra bunken. (Tast J): ";

        return s;
    }

    //Todo:implementer denne metode sådan at der bliver trukket et kort fra bunken (se Task 2.b)
    public String onAccept(){

        return "";
    }

}