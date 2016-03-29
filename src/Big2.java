/**
 * Created by anon on 22/3/2016.
 */
public class Big2 extends CardGame {
    public Big2(int numPlayers) {
        this.deck = new Deck();
        this.player = new B2Player[numPlayers];
        for (int i = 0; i < this.player.length; i++) {
            this.player[i] = new B2Player();
        }
    }

    @Override
    public void playOneGame() {
        // distribute all cards to player
        deck.distributeAllCards(player);
        // Print cards before start
        System.out.println("Before the game starts:");
        for (int i = 0; i < player.length; i++) {
            player[i].printHand();
        }
        int winner = -1;
        Card topCard = new Card(Rank.THREE, Suit.DIAMOND); // Placeholder card

        int currentPlayer; // Iterating variable

        // find the player with D3 and take it away
        for (currentPlayer = 0; currentPlayer < player.length; currentPlayer++) {
            if (((B2Player) player[currentPlayer]).hasD3()) {
                System.out.println("Player " + currentPlayer + " has Diamond 3.");
                break;
            }
        }


        System.out.println();
        int lastDealingPlayer = -1; // Number of people passed
        int roundCount = 0;
        int playersPlayed = 0; // Players played in this round

        for (currentPlayer = 0; // The first player dealing cards should be the D3 guy
             winner == -1; // If nobody is winning
             currentPlayer = (currentPlayer + 1) % player.length) { // Give next player to play it
            if (++playersPlayed % player.length == 1) {
                System.out.println();
                System.out.print("Round " + ++roundCount + " : ");
            }
            /*for (int j = 0; j < player.length; j++) {
                System.out.print("Player " + Integer.toString(j) + ": ");
                player[j].printHand();
            }
            System.out.println("\nTop card is " + topCard + ".");
            */
            Card dealtCard = (Card) player[currentPlayer].dealCard(topCard);
            if (dealtCard != null) {
                topCard = dealtCard;
                System.out.print("P" + Integer.toString(currentPlayer) + " plays " + topCard.toString() + "; ");
                lastDealingPlayer = (currentPlayer + player.length - 1) % player.length;
            } else {
                // The last guy dealing cards = currentPlayer when passed is incremented -1
                System.out.print("P" + Integer.toString(currentPlayer) + " plays PASS; ");


            }
            if (currentPlayer == lastDealingPlayer) {
                // Everyone passed
                System.out.println("\nPlayer " + lastDealingPlayer + " plays the largest card in this round.");
                lastDealingPlayer = -1; // Reset this
                topCard = (Card) player[currentPlayer].dealCard();
                // With no card supplied it removes the smallest card
                System.out.println("Player " + currentPlayer + " plays the smallest card: " + topCard);
            }
            if (!player[currentPlayer].hasCards()) winner = currentPlayer;
        }
        System.out.println("The winner is Player " + Integer.toString(winner));

    }
}
