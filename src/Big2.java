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
        Card topCard = null; // There is no card yet

        int currentPlayer; // Iterating variable

        // find the player with D3 and take it away
        for (currentPlayer = 0; currentPlayer < player.length; currentPlayer++) {
            if (((B2Player) player[currentPlayer]).hasD3()) {
                System.out.println("Player " + currentPlayer + " has Diamond 3.");
                break;
            }
        }


        System.out.println();
        int roundCount = 0;
        int playersPassed = 0; // Number of players passed in this round
        int cardsPlayed = 0; // Number of cards amd passes given out this round

        for (; // The first player dealing cards should be the D3 guy
             winner == -1; // If nobody is winning
             currentPlayer = (currentPlayer + 1) % player.length) { // Give next player to play it

            if (playersPassed == player.length) {
                // Put after all pass check, or else a extra round may be counted
                // Everyone passed once
                System.out.println("\nPlayer " + currentPlayer + " plays the largest card in this round.");
                playersPassed = 0;
                cardsPlayed = 0;
                currentPlayer = (currentPlayer + player.length - 1) % player.length; // Its your turn again
                topCard = null; // So currentPlayer will draw the smallest card
                System.out.println();
                for (int i = 0; i < player.length; i++) {
                    System.out.print("Player "+i+" : ");
                    player[i].printHand();
                }
                continue;
            }


            if (cardsPlayed == 0) {
                // Don't need double new line here
                System.out.print("Round " + ++roundCount + " : ");
            }
            else if (cardsPlayed % player.length == 0) {
                // If round count is increase display it
                System.out.print("\nRound " + ++roundCount + " : ");
            }
            /*for (int j = 0; j < player.length; j++) {
                System.out.print("Player " + Integer.toString(j) + ": ");
                player[j].printHand();
            }
            System.out.println("\nTop card is " + topCard + ".");
            */
            Card dealtCard = (Card) player[currentPlayer].dealCard(topCard);
            cardsPlayed++;
            if (dealtCard != null) {
                topCard = dealtCard;
                System.out.print("P" + Integer.toString(currentPlayer) + " plays " + topCard.toString() + "; ");
              } else {
                System.out.print("P" + Integer.toString(currentPlayer) + " plays PASS; ");
                playersPassed++;
            }

            if (!player[currentPlayer].hasCards()) winner = currentPlayer;
        }
        System.out.println();
        System.out.println("Player  " + Integer.toString(winner)+" has won!");

    }
}
