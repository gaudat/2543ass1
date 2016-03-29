import java.util.ArrayList;

public class OMPlayer extends Player{

    public OMPlayer(Card... cards) {
        super(cards);
    }

    @Override
    public Card dealCard(Card... cards) {
        if (hand.size() == 0) return null;
        return hand.remove((int)(Math.random()*hand.size()));
    }

    public int _removeCardInPairs() {
        ArrayList<Card> tmp = new ArrayList<>(hand);
        boolean[] removedInThisRank = new boolean[Rank.values().length];
        Card[] firstInRank = new Card[Rank.values().length];
        int cardsRemoved = 0;
        for (Card c:hand) {
            if (firstInRank[c.getRank().ordinal()] == null) {
                firstInRank[c.getRank().ordinal()] = c;
            } else if (!removedInThisRank[c.getRank().ordinal()]) {
                //System.out.println("Removed "+c+" and "+firstInRank[c.getRank().ordinal()] +".");
                tmp.remove(c);
                tmp.remove(firstInRank[c.getRank().ordinal()]);
                removedInThisRank[c.getRank().ordinal()] = true;
                cardsRemoved++;
            }
        }

        hand=tmp;
    return cardsRemoved;
    }

    public void removeCardInPairs() {
        // remove pairs recursively
        int cardsRemoved = 1;
        while(cardsRemoved > 0) {
            cardsRemoved = _removeCardInPairs();
            }
    }

}
