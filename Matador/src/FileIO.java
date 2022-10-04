import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    public static void writeGameData(ArrayList<Player> players) {
        try {
            FileWriter writer = new FileWriter("Data\\gamedata.csv");
            for (Player p : players) {
                writer.write(p.getName() + "," + p.getBankAccount().getBalance() +"\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
}
