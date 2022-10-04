import java.util.ArrayList;

public class Game {

    private final FileIO fileIO = new FileIO();
    private final TextUI textUI = new TextUI();
    private int startValue = 30000;
    private int maxPlayers = 6;
    private final ArrayList<Player> players = new ArrayList<>();

    public Game() {

    }

    public void gameSetup() {
        ArrayList<String> data = fileIO.readGameData();
        // tjek om der er spildata
        if (data.isEmpty()) {
            // ellers start en dialog med brugeren
            data = textUI.getUserInput("Skriv spillernavn. Tast Q for at quitte", maxPlayers);
        }
        createPlayers(data);
    }

    public void createPlayers(ArrayList<String> data) {
        for (String s : data) {
            String[] values = s.split(",");
            int balance = startValue;
            if (values.length > 1) {
                balance = Integer.parseInt(values[1].trim());
            }
            Player p = new Player(values[0], balance);
            players.add(p);
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void displayPlayers() {
        for (Player p : players) {
            System.out.println(p);
        }
    }
}