import java.util.ArrayList;

public class Game {

    private final FileIO fileIO = new FileIO();
    private final TextUI textUI = new TextUI();
    private final ArrayList<Player> players = new ArrayList<>();
    private Board board;
    private Player currentPlayer;

    public Game() {

    }

    public void gameSetup() {
        //**********************
        // Load af spiller data
        // **********************
        ArrayList<String> data = fileIO.readGameData();
        if (data.isEmpty()) {
            data = textUI.getUserInput("Skriv spillernavn. Tast Q for at quitte", 6);
        }
        createPlayers(data);

        //******************************************************
        // Load af felt data og bygge boardet
        //******************************************************
        String[] fieldData = fileIO.readBoardData();
        ArrayList<String> chanceData = fileIO.readChanceData();

        board = new Board(fieldData, chanceData);

        runGame();
    }


    public void runGame() {
        String input = "";
        int count = 0;

        //Test: Egon starter med at købe et par grunde til hhv. 2000 og 8000 kr, og modtager nogle penge //Nu kan det testes at der trækkes det rigtige i skat hvis han siger nej til at betale det faste beløb
        Field somePlot = board.getField(6);//et rederi
        players.get(0).buy(somePlot.cost);
        players.get(0).addDeed((Property)somePlot);

        somePlot = board.getField(40);//rådhuspladsen
        players.get(0).buy(somePlot.cost);
        players.get(0).addDeed((Property)somePlot);

        players.get(0).receive(20000);//med denne linje modtager Egon et beløb uden skøde

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
        result = 4;
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
            int balance = 30000;
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