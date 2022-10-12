public class Visit extends Field {

    public Visit(int id, String label) {
        super(id, label, 0, 0);
    }

    @Override
    public String onLand(Player p) {
        return super.onLand(p) + "\nBesøg";
    }

    @Override
    public String onAccept(Player p) {
        return super.onAccept(p) + "\nBesøg";
    }

    @Override
    public String onReject(Player p) {
        return super.onReject(p) + "\nBesøg";
    }

}