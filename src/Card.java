public class Card implements Comparable<Card> {

    // define instance variables for the rank and suit of the card
    // you might want to define an instance variable for the rank
    // of this card in the whole deck, eg, the rank in deck of
    // Ace of Spades is 11 and the rank in deck of Two of Diamonds
    // is 52


    // define necessary constructor(s)

    private Rank rank;
    private Suit suit;

    public Card(Rank r, Suit s) {
        this.rank = r;
        this.suit = s;
    }

    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public void setRank(Rank r) {
        this.rank = r;
    }

    public void setSuit(Suit s) {
        this.suit = s;
    }

    public int howBig() {
        // helper function
        return this.rank.ordinal() * Suit.values().length + Suit.values().length - this.suit.ordinal();
    }


    public String toString() {
        return suit.toString() + rank.toString();
    }

    public int compareTo(Card ref) {
        // The card is bigger if the ordinal is smaller
        return this.howBig() - ref.howBig();

    }

    public int B2StyleHowBig() {
        // Big 2 style card bigness
        return (this.rank.ordinal() + Rank.values().length - 1) % Rank.values().length * Suit.values().length + Suit.values().length - this.suit.ordinal();
    }

}
