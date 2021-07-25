package novi.blackjack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner inputScanner = new Scanner(System.in);
        BlackJackGame game = new BlackJackGame(inputScanner);
        game.playGame();
        System.out.println("\n\nThe game has ended");
    }
}
