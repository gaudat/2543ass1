// YOU CANNOT MODIFY THIS FILE

public enum Suit {
  SPADE("S"), 
  HEART("H"), 
  CLUB("C"), 
  DIAMOND("D");

  private String s;

  // Constructor
  Suit (String name) {
    s = name;
  }

  public String toString() {
    return s;
  }
}
