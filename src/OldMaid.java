

public class OldMaid extends CardGame {


    public OldMaid(int numPlayers) {
        /*
        Creates a new OldMaid instance.
        numPlayers: number of players in the game. Must be between 2 and 8.
         */
        this.deck = new Deck();
        this.player = new OMPlayer[numPlayers];
        for (int i = 0; i < numPlayers; i++)
            this.player[i] = new OMPlayer();

    }

    public void playOneGame() {
        Card oldMaid = deck.drawCard(); // This is pointless

        deck.distributeAllCards(this.player);

        // print the cards in each player has
        //System.out.println("Before removing pairs:");
        /*for (int i = 0; i < player.length; i++) {
            System.out.print("Player " + i + " : ");
            player[i].printHand();
        }*/

        // REMOVE PAIRS OF CARDS FOR EACH PLAYER
        for (Player p : player) {
            ((OMPlayer) p).removeCardInPairs();
        }

        // print the cards in each player has
        /*System.out.println("\nAfter removing pairs:");
        for (int i = 0; i < player.length; i++) {
            System.out.print("Player " + i + " : ");
            player[i].printHand();
        }*/

        // IDENIFY WHO SHOULD PLAY FIRST
        // BREAK TIES BY PLAYER ID
        int leastCardPlayer = 0;
        int leastCardPlayerCards = Rank.values().length * Suit.values().length;
        for (int i = 0; i < player.length; i++) {
            if (player[i].hand.size() < leastCardPlayerCards) {
                leastCardPlayer = i;
            }
        }
        System.out.println("Player " + leastCardPlayer + " is the first player.");

        // THE GAME
        int playerWon = -1;
        int roundCount = 0;

        for (int i = leastCardPlayer;
                ; // Always true because we exit the loop by breaking it
             i = (i + 1) % player.length) {
            if (i == leastCardPlayer) {
                System.out.println("Round " + ++roundCount);
                for (int j = 0; j < player.length; j++) {
                    System.out.print("Player " + j + " : ");
                    player[j].printHand();
                    }
                }


            Card c = ((OMPlayer) player[(i + 1) % player.length]).dealCard();

            System.out.println("Player " + i + " draws " + c + " from Player " + (i + 1) % player.length);
            player[i].addCard(c);
            ((OMPlayer) player[i]).removeCardInPairs();
            if (!player[i].hasCards()) {
                playerWon = (i + 1) % player.length;
                break;
            }

        }
        System.out.println("Player " + playerWon + " has won!");

    }

}

