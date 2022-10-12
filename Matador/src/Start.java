public class Start extends Field {

    public Start(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }

    @Override
    public String onLand(Player p) {
        return super.onLand(p) + "\nModtag";
    }

    @Override
    public String onAccept(Player p) {
        return super.onAccept(p) + "\nModtag";
    }

    @Override
    public String onReject(Player p) {
        return super.onReject(p) + "\nModtag";
    }

}