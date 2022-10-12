public class Plot extends Property {

    public Plot(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income, seriesID);
    }

    /*
    boolean monopoly = false;

    @Override
    public String onLand(Player p) {
        if (this.getOwner() == p) {
            String s = "";
            if (monopoly) {
                s = "1";
            } else {
                s = "2";
            }
            return s;
        }
        return super.onLand(p);
    }
    */
}