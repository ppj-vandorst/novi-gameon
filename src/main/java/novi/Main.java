package novi;

import novi.higherlower.HigherLowerGame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        HigherLowerGame game = new HigherLowerGame();

        while (true) {
            while (!game.isRunning()) {
                System.out.println("Press p to start a game or q to stop");
                String input = inputScanner.next();

                if (input.equals("p")) {
                    game.startGame();
                } else if (input.equals("q")) {
                    inputScanner.close();
                    System.exit(0);
                }
            }

            System.out.println("You started a game of Higher Lower!");
            while (game.isRunning()) {
                System.out.println("Make a guess");

                if (inputScanner.hasNextInt()) {
                    System.out.println(game.performGuess(inputScanner.nextInt()));
                } else {
                    System.out.println("That is not a number");
                }
            }
        }
    }
}
