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

    public String onAccept(Player p){
        ChanceCard card = Board.getChanceCard();
        if (card.getCost() > 0){
            p.pay(card.getCost());
        } else {
            p.receive(card.getIncome());
        }
        return "Du trak chancekortet " + card.getName() + (card.getCost() > 0 ? " og skal betale " + card.getCost() + " kr." : " og modtager " + card.getIncome() + " kr.");
    }
}