public abstract class CardGame {
  protected Deck deck;
  protected Player[] player;

  public void printAllHands() {
    int numPlayers = player.length;
    for (int i = 0; i < numPlayers; i++) {
      System.out.print("Player " + i + " : ");
      player[i].printHand();
    }
  }

  public abstract void playOneGame();
}
