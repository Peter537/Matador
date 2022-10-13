import java.util.Random;

public class Dice {

    private final Random random = new Random();

    public int[] rollDice() {
        int[] dice = new int[2];
        dice[0] = random.nextInt(6) + 1;
        dice[1] = random.nextInt(6) + 1;
        return dice;
    }

    public int rollDiceSum() {
        int[] dice = rollDice();
        return dice[0] + dice[1];
    }
}