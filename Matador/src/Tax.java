public class Tax extends Field {

    public Tax(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }

    @Override
    public String onLand(Player p) {
        return super.onLand(p) + "\nDu skal betale skat. Tast J for fast beløb: " + cost + ", ellers tager vi 10% af dine aktiver.";
    }

    @Override
    public String onAccept(Player p) {
        p.pay(cost);
        return p.getName() + " har betalt " + cost + " kr. i skat.";
    }

    @Override
    public String onReject(Player p) {
        float calcTax = p.getBankAccount().getBalance() * 0.1f;
        /*Todo: skriv metoden calculateAssets jvf. Task 1.a, så den kaldes fra linjen herunder, som du indkommenterer når metoden er skrevet*/
        //calcTax += calculateAssets(Player p);
        p.pay((int) calcTax);
        return "Vi har trukket 10% af dine aktiver";
    }
}