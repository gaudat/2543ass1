/**
 * Created by anon on 22/3/2016.
 */
public class LCPlayer extends Player {
    @Override
    public Card dealCard(Card... cards) {
        /*
        Deals a card according to last card rules. returns null if no applicable cards in hand.
         */
        if (cards.length > 1) {
            System.out.println("Too much cards. Only one please.");
            return null;
        }

        Card topCard = cards[0];

        // index of the card to be removed. -1 means no card is good
        int target = -1;

        for (int i = 0; i < hand.size(); i++) {
            if (topCard.getRank() == hand.get(i).getRank() || topCard.getSuit() == hand.get(i).getSuit()) {
                // same rank or same suit
                target = i;
            }
        }
        return target == -1 ? null : hand.remove(target);
    }
}
