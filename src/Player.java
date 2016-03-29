import java.util.ArrayList;
import java.util.Collections;

public abstract class Player {

    protected ArrayList<Card> hand;

    public void printHand() {
        System.out.println(hand);
    }

    public Player(Card... cards) {
        hand = new ArrayList<>();
        Collections.addAll(hand,cards);
        Collections.sort(hand);
    }

    public void addCard(Card c) {
        hand.add(c);
        Collections.sort(hand);
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    abstract public Comparable<? extends Comparable<? extends Comparable<?>>> dealCard(Card... cards);



}
