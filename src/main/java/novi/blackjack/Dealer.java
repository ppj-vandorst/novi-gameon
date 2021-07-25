package novi.blackjack;

public class Dealer {
    public Hand hand;
    private boolean staying;

    public Dealer() {
        this.hand = new Hand();
    }

    public void performMove(Deck deck) {
        if (hand.getTotalValue() < 17) {
            hand.addCard(deck.getNextCard());
        } else {
            this.staying = true;
        }
    }

    public void addCardsToHand(Card... cards) {
        for (Card card : cards) {
            hand.addCard(card);
        }
    }

    public String renderHand() {
        return hand.render();
    }

    public boolean isBust() {
        return hand.getTotalValue() > 21;
    }

    public int getHandValue() {
        return hand.getTotalValue();
    }

    public boolean isStaying() {
        return staying;
    }
}
