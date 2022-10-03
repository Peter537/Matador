import java.util.ArrayList;
import java.util.Optional;

public class Game {

    FileIO fileIO = new FileIO();
    TextUI textUI = new TextUI();
    private int startValue = 30000;
    private int maxPlayers = 6;
    private ArrayList<Player> players = new ArrayList<>();

    public Game() {

    }

    public void gameSetup() {
        ArrayList<String> data = fileIO.readGameData();
        // tjek om der er spildata
        if (data == null) {
            // ellers start en dialog med brugeren
            System.out.println("");
            data = textUI.getUserInput("Skriv spillernavn. Tast Q for at quitte", maxPlayers);

        }

        createPlayers(data);
    }

    public void createPlayers(ArrayList<String> data) {
        for (String s : data) {
            String[] values = s.split(",");
            int amount = startValue;
            if (values.length > 1) {
                amount = Integer.parseInt(values[1]);
            }
            Player p = new Player(values[0], amount);
            players.add(p);
        }
    }

    public void showPlayers() {
        for (Player p : players) {
            System.out.println(p);
        }
    }

}