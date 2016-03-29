/**
 * Created by anon on 26/3/2016.
 */
public class SmartB2Player extends B2Player {
    // A smarter B2 player.

    private int cardsDealedInThisRound = 0;

    public Card dealCard(Card... cards) {
        // Removes the next bigger card if I haven't dealt 3 cards in this round.
        // Removes the biggest card if this is the fourth time in this round.
        int target = -1;

        if (cards.length == 1) {
            if (cardsDealedInThisRound < 3) {

                int maxDifference = -1; // Difference between target card and reference
                for (int i = 0; i < hand.size(); i++) {
                    int diff = hand.get(i).compareTo(cards[0]);
                    if (diff > 0 && (maxDifference == -1 || diff < maxDifference)) {
                        maxDifference = diff;
                        target = i;
                    }
                }
                cardsDealedInThisRound++;
            } else {
                target = hand.size() - 1;
            }
            return target == -1 ? null : hand.remove(target);

        } else {
            // removes smallest card
            int minSize = -1;
            for (int i = 0; i < hand.size(); i++) {
                int cSize = hand.get(i).B2StyleHowBig();
                if (cSize < minSize || minSize == -1) {
                    minSize = cSize;
                    target = i;
                }
            }
            return hand.remove(target);
        }
    }
}
