import java.util.ArrayList;

public class Game {

    private final FileIO fileIO = new FileIO();
    private final TextUI textUI = new TextUI();
    private int startValue = 30000;
    private int maxPlayers = 6;
    private final ArrayList<Player> players = new ArrayList<>();
    private Board board;
    private Player currentPlayer;

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

        //******************************************************
        // Load af felt data og bygge boardet
        //******************************************************
        String[] fieldData = fileIO.readBoardData();
        board = new Board(fieldData);

        runGame();
    }

    /* TODO: Increase modularity for readability in this class by...
    1. moving the code that rolls the dice and moves the player to a method called throwAndMove()
    2. moving the code that calls the onLand method to a method called landAndAct()
    3. limit the code in runGame to run a game loop, where..
    3.a the next player is found
    3.b the user is prompted to either continue or quit the game
    *
    * */

    public void runGame() {
        String input = "";
        int count = 0;
        while (!input.equalsIgnoreCase("Q")) {
            currentPlayer = players.get(count % players.size());
            throwAndMove();
            input = textUI.getUserInput("Continue (C) or Quit (Q)?");
            count++;
            /* Bruger modulo til at finde den næste spiller i listen
            if (count == players.size()) {
                count = 0;
            }
            */
        }

    }

    private void throwAndMove() {
        System.out.println("Det er " + currentPlayer.getName() + "'s tur.\n"
                + currentPlayer.getName() + " har lige nu " + currentPlayer.getBankAccount().getBalance() + " kr.\n"
                + currentPlayer.getName() + " står på felt " + currentPlayer.getPosition() + ".");
        int result = board.getDice().rollDiceSum();
        result = 5;
        int newPos = currentPlayer.updatePosition(result);
        Field f = board.getField(newPos);
        landAndAct(f);

        textUI.displayMessage(currentPlayer.getName() + " har lige nu " + currentPlayer.getBankAccount().getBalance() + " kr.\n");
    }

    private void landAndAct(Field f) {
        String optionMsg = f.onLand(currentPlayer);
        String choice = textUI.getUserInput(optionMsg);
        String msg = f.processChoice(choice, currentPlayer);
        textUI.displayMessage(msg);
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

    public void displayPlayers() {
        for (Player p : players) {
            System.out.println(p);
        }
    }

    public void saveData() {
        fileIO.writeGameData(players);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public FileIO getFileIO() {
        return fileIO;
    }

    public TextUI getTextUI() {
        return textUI;
    }
}