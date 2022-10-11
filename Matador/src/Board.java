public class Board {

    private final Dice dice = new Dice();
    private final Field[] fields = new Field[40];

    public Board(String[] data) {
        createFields(data);
    }

    private void createFields(String[] data) {
        for (String s : data) {
            String[] values = s.split(",");
            /*TODO: Instantiate subclasses of Field based on data. (No field is just a field)
               1. add a switch-case that looks at the type of the field to be created
               2. create the subclasses need to instiate based on the type of field. (constructor, attributes and override onString and onLand methods)
            *
            *  PSEUDO CODE:
            *
            *  Field f = null;
            *  switch(values[1])
            *  case "plot": f = new Plot(...)
            *
            */
            int id = Integer.parseInt(values[0].trim());
            String fieldType = values[1];
            String label = values[2];
            int cost = Integer.parseInt(values[3].trim());
            int income = Integer.parseInt(values[4].trim());
            int seriesID = Integer.parseInt(values[5].trim());
            Field f;
            switch (fieldType) {
                case "plot":
                    f = new Plot(id, label, cost, income, seriesID);
                    break;
                case "lykkefelt":
                    f = new Chance(id, label, cost, income);
                    break;
                case "tax":
                    f = new Tax(id, label, cost, income);
                    break;
                    /*
                case "jail":
                    f = new Jail(id, label, cost, income, seriesID);
                    break;
                case "startfelt":
                    f = new Start(id, label, cost, income, seriesID);
                    break;
                case "extraTax":
                    f = new ExtraTax?Tax?(id, label, cost, income, seriesID);
                    break;
                case "brewery":
                    f = new Brewery(id, label, cost, income, seriesID);
                    break;
                case "rederi":
                    f = new (id, label, cost, income, seriesID);
                    break;
                case "parking":
                    f = new Parking(id, label, cost, income, seriesID);
                    break;
                    */
                default:
                    f = new Field(id, label, cost, income);
                    break;
            }

            fields[id - 1] = f;
            // startfelt, plot, lykkefelt, tax, rederi, jail, brewery, parking, extraTax

            //fields[ID - 1] = new Field(ID, label, cost, income, seriesID, null);
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