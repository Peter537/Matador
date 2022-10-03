/*
Todo: Tilføj en metode der prompter brugeren for en værdi indtil et max er nået eller brugeren taster q for quit

Lad metoden tage et argument for besked der skal vises hver gang brugeren promptes og et argument for maximum antal gange brugeren skal promptes
Hver gang brugeren taster et input, skal værdien placeres i en liste af Strings som returnes til allersidst.


Alle metoderne i denne klasse skal hedde getUserInput, men de tager forskellige argumenter. Dette kaldes 'overloading'.'

*/

import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    static Scanner scan = new Scanner(System.in);

    //recieves a message and displays it to the user
    //prompts the user for a reponse

    String getUserInput(String msg){
        //besked fra systemet
        System.out.println(msg);
        //svar fra bruger
        String input = scan.nextLine();
        return input;
    }

    ArrayList<String> getUserInput(String msg, int iterations) {
        ArrayList<String> inputs = new ArrayList<>();
        while (iterations > 0) {
            System.out.println(msg);
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            inputs.add(input);
            iterations--;
        }
        return inputs;
    }


    public int getUserChoice(ArrayList<String> arr){
        String msg =  "Du har følgende valgmuligheder";
        System.out.println(msg);
     
        for(int i = 0; i<arr.size(); i++){

            System.out.println(i+1+". "+arr.get(i));
        }
        int choice = scan.nextInt();
        return choice;
    }
}
