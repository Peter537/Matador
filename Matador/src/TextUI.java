import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {

    private static final Scanner scanner = new Scanner(System.in);

    /*
        receives a message and displays it to the user
        prompts the user for one input value
        returns the input
    */
    public String getUserInput(String msg){
        System.out.println(msg);
        return scanner.nextLine();
    }

    /*
        receives a message and displays it to the user
        prompts the user for multiple[iterations] input values
        returns a list of inputs
    */
    public ArrayList<String> getUserInput(String msg, int iterations) {
        ArrayList<String> inputs = new ArrayList<>();
        while (iterations > 0) {
            System.out.println(msg);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            inputs.add(input);
            iterations--;
        }
        return inputs;
    }

    /*
        receives a message and displays it to the user
        displays a list of options
        prompts the user for one input value
        returns the input
    */
    public int getUserInput(String msg, ArrayList<String> arr){
        System.out.println(msg);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println((i + 1) + ". " + arr.get(i));
        }
        return scanner.nextInt();
    }
}
