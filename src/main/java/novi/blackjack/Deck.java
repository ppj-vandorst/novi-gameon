package novi.blackjack;

import java.util.Random;
import java.util.Stack;

public class Deck {
    private Stack<Card> deck;
    private CardSuit[] cardSuites;
    private CardValue[] cardValues;

    public Deck() {
        cardSuites = new CardSuit[] { new CardSuit("diamonds", '\u2666', "red"),
                new CardSuit("spades", '\u2660', "black"), new CardSuit("hearts", '\u2665', "red"),
                new CardSuit("clubs", '\u2663', "black") };
        cardValues = new CardValue[] { new CardValue("two", 2), new CardValue("three", 3), new CardValue("four", 4),
                new CardValue("five", 5), new CardValue("six", 6), new CardValue("seven", 7), new CardValue("eight", 8),
                new CardValue("nine", 9), new CardValue("ten", 10), new CardValue("jack", 10),
                new CardValue("queen", 10), new CardValue("king", 10) };

        deck = new Stack<>();
        for (CardSuit suite : cardSuites) {
            for (CardValue value : cardValues) {
                deck.add(new Card(suite, value));
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int j = 0; j < deck.size(); j++) {
            int shuffleIndex = random.nextInt(deck.size());
            Card hold = deck.get(j);
            deck.set(j, deck.get(shuffleIndex));
            deck.set(shuffleIndex, hold);
        }
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }

    public Card getNextCard() {
        return deck.pop();
    }
}
