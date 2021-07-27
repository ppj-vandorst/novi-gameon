package novi.blackjack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        String variant;
        do {
            System.out.println("Which variant do you want to play? (simple or lowdeck)");
            variant = inputScanner.nextLine();
        } while (!variant.equals("simple") && !variant.equals("lowdeck"));

        BlackjackGame game;
        if (variant.equals("simple")) {
            game = new SimpleBlackjack(inputScanner);
        } else {
            game = new LowDeckBlackjack(inputScanner);
        }

        game.playGame();

        System.out.println("\n\nThe game has ended");
    }
}
