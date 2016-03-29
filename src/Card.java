public class Card implements Comparable<Card> {

    // define instance variables for the rank and suit of the card
    // you might want to define an instance variable for the rank
    // of this card in the whole deck, eg, the rank in deck of
    // Ace of Spades is 11 and the rank in deck of Two of Diamonds
    // is 52


    // define necessary constructor(s)

    private Rank rank;
    private Suit suit;
    private boolean useB2StyleCompare;

    public Card(Rank r, Suit s) {
        new Card(r, s, false);
    }

    public Card(Rank r, Suit s, boolean useB2StyleCompare) {
        // use B2 style compare
        this.rank = r;
        this.suit = s;
        this.useB2StyleCompare = useB2StyleCompare;
    }

    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public int howBig() {
        return this.rank.ordinal() * Suit.values().length + Suit.values().length - this.suit.ordinal();
    }


    public String toString() {
        return suit.toString() + rank.toString();
    }

    public int compareTo(Card ref) {
        // The card is bigger if the ordinal is smaller

        return useB2StyleCompare ? this.B2StyleHowBig() - ref.B2StyleHowBig() : this.howBig() - ref.howBig();

    }

    public int B2StyleHowBig() {
        // Big 2 style card bigness
        return (this.rank.ordinal() + Rank.values().length - 1) % Rank.values().length * Suit.values().length + Suit.values().length - this.suit.ordinal();
    }

}
