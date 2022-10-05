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
            String label = values[1].trim();
            int cost = Integer.parseInt(values[2].trim());
            int income = Integer.parseInt(values[3].trim());
            int seriesID = Integer.parseInt(values[4].trim());
            fields[ID - 1] = new Field(ID, label, cost, income, seriesID, null);
        }
    }

    public Field getField(int id) {
        return ((id - 1) >= fields.length || (id - 1 < 0)) ? fields[id - 1] : null;
    }
}