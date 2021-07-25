package novi.blackjack;

import java.util.Scanner;

public class BlackJackGame {
    Scanner inputScanner;

    boolean gameIsRunning;
    int currentValue;
    Deck deck;
    Player player;
    Dealer dealer;

    public BlackJackGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public void playGame() throws InterruptedException {
        gameIsRunning = true;
        currentValue = 0;

        deck = new Deck();
        player = new Player();
        dealer = new Dealer();

        deck.shuffle();
        dealer.addCardsToHand(deck.getNextCard());
        player.addCardsToHand(deck.getNextCard(), deck.getNextCard());

        renderRules();
        while (gameIsRunning) {
            runGameLoop();
            Thread.sleep(1000);
        }
    }

    private void runGameLoop() {
        renderTableState();

        if (player.isBust() || player.isStaying() && player.getHandValue() <= dealer.getHandValue()) {
            System.out.println("You lost!");
            gameIsRunning = false;
            return;
        }

        if (dealer.isBust() || dealer.isStaying() && player.getHandValue() > dealer.getHandValue()) {
            System.out.println("You won!");
            gameIsRunning = false;
            return;
        }

        if (!player.isStaying()) {
            String move = getNextUserMove();
            player.performMove(deck, move);
        }

        if (!dealer.isStaying() && !player.isBust()) {
            dealer.performMove(deck);
        }
    }

    private String getNextUserMove() {
        while (true) {
            System.out.println("What do you want to do? (hit or stay)");
            String input = inputScanner.nextLine();

            if (input.equals("hit") || input.equals("stay")) {
                return input;
            } else {
                continue;
            }
        }
    }

    private void renderTableState() {
        System.out.println("");
        System.out.println("Dealers hand:");
        System.out.println(dealer.renderHand());
        System.out.println("");

        System.out.println("your hand:");
        System.out.println(player.renderHand());
        System.out.println("");
    }

    private void renderRules() {
        System.out.println("Welcome to Blackjack!\n\n");
        System.out.println("  BLACKJACK RULES: ");
        System.out.println(
                "	-Each player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down.");
        System.out.println("	-Cards are equal to their value with face cards being 10.");
        System.out.println("	-The players cards are added up for their total.");
        System.out.println(
                "	-Players “Hit” to gain another card from the deck. Players “Stay” to keep their current card total.");
        System.out.println("	-Dealer “Hits” until they equal or exceed 17.");
        System.out.println("	-The goal is to have a higher card total than the dealer without going over 21.");
        System.out.println("	-If the player total equals the dealer total, it is a “Push” and the hand ends.");
        System.out.println("	-Players win if they beat the dealer\n\n");
    }
}
