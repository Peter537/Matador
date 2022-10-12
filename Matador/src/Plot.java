public class Plot extends Property {

    public Plot(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income, seriesID);
    }

    @Override
    public String onLand(Player p) {
        if (this.getOwner() == p) {
            /*TODO: følg aktivitetsdiagrammet Documentation/activity_OnLand_Plot_v1.1*/
            String s = "";
            if (monopoly) {
                s = "1";
            } else {
                s = "2";
            }
            return s;
        }
        //Dette sker kun hvis feltet ikke ejes af spilleren
        return super.onLand(p);
    }
}