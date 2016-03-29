import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by anon on 22/3/2016.
 */
public class B2Player extends Player {
    // A big 2 player.

    public B2Player(Card... cards) {
        this.hand = new ArrayList<>();
        Collections.addAll(hand, cards);
    }


    public Card dealCard(Card... cards) {
        // Removes a card just bigger than the card supplied
        if (cards.length == 0 || cards[0] == null ) {

            return hand.remove(0);
        } else {
            // finds first card bigger and removes it
            // as hand is sorted, the card is guaranteed to be just bigger
            int target = -1;
            int maxDifference = -1; // Difference between target card and reference
            for (int i = 0; i < hand.size(); i++) {
                int diff = hand.get(i).compareTo(cards[0]);
                if (diff > 0 && (maxDifference == -1 || diff < maxDifference)) {
                    maxDifference = diff;
                    target = i;
                }
            }

            return target == -1 ? null : hand.remove(target);

        }
    }

    public void addCard(Card c) {
        hand.add(c);
        Collections.sort(hand);
    }

    public boolean hasD3() {
        // Does the player have B2 in hand?
        int target = -1;
        for (int i=0;i<hand.size();i++) {
            if (hand.get(i).getRank() == Rank.THREE && hand.get(i).getSuit() == Suit.DIAMOND) {
                target = i;
            }
        }
        return target != -1;
    }
}
