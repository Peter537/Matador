public class Parking extends Field {

    public Parking(int id, String label) {
        super(id, label, 0, 0);
    }

    @Override
    public String onLand(Player p) {
        return super.onLand(p) + "\nGratis parkering";
    }

    @Override
    public String onAccept(Player p) {
        return super.onAccept(p) + "\nGratis parkering";
    }

    @Override
    public String onReject(Player p) {
        return super.onReject(p) + "\nGratis parkering";
    }
}