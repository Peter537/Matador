public class Board {

    private final Dice dice = new Dice();
    private final Field[] fields = new Field[40];

    public Board(String[] data) {
        createFields(data);
    }

    private void createFields(String[] data) {
        for (String s : data) {
            String[] values = s.split(",");
            int ID = Integer.parseInt(values[0].trim());
            String fieldType = values[1]; // Bruges ikke pt.
            String label = values[2];
            int cost = Integer.parseInt(values[3].trim());
            int income = Integer.parseInt(values[4].trim());
            int seriesID = Integer.parseInt(values[5].trim());
            fields[ID - 1] = new Field(ID, label, cost, income, seriesID, null);
        }
    }

    public Field getField(int id) {
        id--;
        return (id >= 0 && id < fields.length) ? fields[id] : null;
    }

    public Dice getDice() {
        return dice;
    }
}