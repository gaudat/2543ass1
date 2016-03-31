/**
 * Created by anon on 26/3/2016.
 */
public class SlighlySmarterB2Player extends B2Player {
    // A slightly smarter B2 player.
    // Win rate is about 10% higher

    private int cardsDealtInThisRound = 0;
    private int roundsPlayed = 0;

    public Card dealCard(Card... cards) {
        // Play 2 rounds normally, then deliver cards from biggest to smallest
        int target = -1;

        if (cards.length == 0 || cards[0] == null) {
            // Pull smallest card
            roundsPlayed++;
            cardsDealtInThisRound = 0;
            return hand.remove(0);
        } else {
            if (cards[0].howBig() > new Card(Rank.KING, Suit.DIAMOND).howBig()
                    || roundsPlayed > 3 || roundsPlayed > 2 && cardsDealtInThisRound > 2
                // The above condition is determined experimentally
                // by changing the expression one step and run B2 1000 times
                // If the winning rate increases keep it
                // If the winning rate decreases trash it
                    ) {
                // biggest card
                if (hand.get(hand.size() - 1).compareTo(cards[0]) > 0) {
                    target = hand.size() - 1;
                }
            } else {
                // just bigger
                int maxDifference = -1; // Difference between target card and reference
                for (int i = 0; i < hand.size(); i++) {
                    int diff = hand.get(i).compareTo(cards[0]);
                    if (diff > 0 && (maxDifference == -1 || diff < maxDifference)) {
                        maxDifference = diff;
                        target = i;
                    }
                }
                cardsDealtInThisRound++;
            }
            return target == -1 ? null : hand.remove(target);
        }
    }
}
