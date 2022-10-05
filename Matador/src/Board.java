public class Board {

    private final Dice dice;
    private final Field[] fields = new Field[40];

    public Board(String[] data) {
        dice = new Dice();
        createFields(data);
    }

    private void createFields(String[] data) {
        for (String s : data) {
            String[] values = s.split(",");
            int ID = Integer.parseInt(values[0].trim());
            String label = values[1].trim();
            int cost = Integer.parseInt(values[2].trim());
            int income = Integer.parseInt(values[3].trim());
            int seriesID = Integer.parseInt(values[4].trim());
            fields[ID - 1] = new Field(ID, label, cost, income, seriesID, null);
        }
    }

    public Field getField(int id) {
        id--;
        if (id >= fields.length || id < 0) {
            return null;
        }
        return fields[id];
    }
}