package novi.hangman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangmanGame game = new HangmanGame(scanner);

        while (true) {
            System.out.println("Welcome to Hangman! press 'p' to start a game\n");

            String line = scanner.nextLine();
            if (line.equals("p")) {
                game.playGame();
            } else {
                System.out.printf("%s is not a valid command\n", line);
            }
        }
    }
}
