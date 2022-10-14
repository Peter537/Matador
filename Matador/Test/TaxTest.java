import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaxTest {

    Game game = new Game();
    Board board;
    ArrayList<Player> players;

    @BeforeEach
    void setUp() {
        game.gameSetup();
        players = game.getPlayers();
        board = game.getBoard();

    }

    @Test
    void onReject() {

        //Test: Egon starter med at købe et par grunde til hhv. 2000 og 8000 kr, og modtager nogle penge //Nu kan det testes at der trækkes det rigtige i skat hvis han siger nej til at betale det faste beløb
        Field somePlot = board.getField(6);//et rederi
        players.get(0).buy((Property) somePlot);

        somePlot = board.getField(40);//rådhuspladsen
        players.get(0).buy((Property) somePlot);

        int expected = 20000;
        int actual = players.get(0).getBankAccount().getBalance();
        assertEquals(expected, actual);

        Field taxPlot = board.getField(5);
        taxPlot.onReject(players.get(0));
        int expected2 = 20000 - (int) (0.1 * (20000 + 2000 + 8000));
        int actual2 = players.get(0).getBankAccount().getBalance();
        assertEquals(expected2, actual2);

    }
}