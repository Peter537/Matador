public class Main {

    private static final Game game = new Game();

    public static void main(String[] args) {
        game.gameSetup();
        game.runGame();
        //game.displayPlayers();
        game.saveData();
    }
}