import java.util.*;

public class Deck {
    protected ArrayList<Card> deck;

    public void printDeck() {
        System.out.println(deck);
    }

    public Deck() {
        // A full deck
        deck = new ArrayList<>();
        for (Rank r:Rank.values()) {
            for (Suit s:Suit.values()) {
                deck.add(new Card(r,s));
            }
        }
        Collections.shuffle(deck);
    }

    public Deck(Card... cards) {
        Collections.addAll(deck, cards);
    }

    public Card drawCard() {
        if (deck.size() == 0) {
            System.out.println("We are out of cards in the deck.");
            return null;
        }
        return deck.remove((int)(Math.random()*deck.size()));
    }

    public void distributeAllCards(Player[] players) {
        for (int i = 0;!deck.isEmpty();i = (i+1)%players.length) {
            players[i].addCard(drawCard());
        }
    }
}
