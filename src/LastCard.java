/**
 * Created by anon on 22/3/2016.
 * <p>
 * A simplified version of last card game
 */
public class LastCard extends CardGame {

    Card topCard;

    public LastCard(int numPlayers) {
        this.deck = new Deck();
        this.player = new LCPlayer[numPlayers];
        for (int i = 0; i < this.player.length; i++) {
            this.player[i] = new LCPlayer();
        }
    }

    @Override
    public void playOneGame() {
        // Each guy gets 4 cards
        for (int i = 0; i < 4; i++) {
            for (Player p : player) {
                p.addCard(deck.drawCard());
            }
        }

        // Print cards before start
        for (int i = 0; i < player.length; i++) {
            System.out.print("Player " + Integer.toString(i) + ": ");
            player[i].printHand();
        }

        // Picks a top card
        topCard = deck.drawCard();

        // Who is the winner? -1 means nobody
        int winner = -1;
        System.out.println("The top card is " + topCard);

        int roundNum = player.length; // Round number, default to player.length so it starts at round 1

        for (int i = 0;
             winner == -1; // No winners yet
             i = (i + 1) % player.length // Increasing player index
                ) {
            roundNum++;
            if (i == 0) {

                System.out.print("Round " + roundNum/player.length + " : ");
            }

            Card dealtCard = ((LCPlayer) player[i]).dealCard(topCard);
            if (dealtCard != null) {
                topCard = dealtCard;
                System.out.print("P" + Integer.toString(i) + " plays " + topCard.toString() + "; ");
                if (!player[i].hasCards()) {
                    winner = i;
                }
            } else {
                Card newCard = deck.drawCard();
                player[i].addCard(newCard);
                System.out.print("P" + Integer.toString(i) + " plays PASS; ");
            }
            if (roundNum % player.length == 0) {
                System.out.println();
                for (int j = 0; j < player.length; j++) {
                    System.out.print("Player " + Integer.toString(j) + " : ");
                    player[j].printHand();
                }
            }
        }
        if (winner != player.length - 1) {
            System.out.println(); // Suppress double new lines
        }
        System.out.println("Player " + Integer.toString(winner) + " has won!");

    }
}
