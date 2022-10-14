import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    public ArrayList<String> readGameData() {
        ArrayList<String> values = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("Data\\gamedata.csv"));
            input.nextLine(); // Ignore header
            while (input.hasNextLine()) {
                values.add(input.nextLine());
            }
            return values;
        } catch (FileNotFoundException ignored) {
        }
        return null;
    }

    public void writeGameData(ArrayList<Player> players) {
        try {
            FileWriter writer = new FileWriter("Data\\gamedata.csv");
            writer.write("# name, balance\n");
            for (Player p : players) {
                writer.write(p.getName() + ", " + p.getBankAccount().getBalance() +"\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] readBoardData() {
        String[] values = new String[40];
        try {
            Scanner input = new Scanner(new File("Data\\boarddata.csv"));
            input.nextLine(); // Ignore header
            for (int i = 0; i < 40; i++) {
                values[i] = input.nextLine();
            }
            return values;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> readChanceData() {
        ArrayList<String> values = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("Data\\chancedata.csv"));
            input.nextLine(); // Ignore header
            while (input.hasNextLine()) {
                values.add(input.nextLine());
            }
            return values;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}