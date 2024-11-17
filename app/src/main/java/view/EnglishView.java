package view;

/**
 * Implements an english console view.
 */
public class EnglishView implements View {

  /**
   * Shows a welcome message.
   */
  public void displayWelcomeMessage() {
    for (int i = 0; i < 2; i++) {
      System.out.print("\n");
    }
    System.out.println("Black Jack World");
    System.out.println("----------------");
    System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
  }

  /**
   * Returns pressed characters from the keyboard.

   * @return the pressed character.
   */
  public int getInput() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      return c;
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return 0;
    }
  }

  /**
   * Returns the option that the user made.
   *
   * @return the option.
   */
  public InputOption getOption() {
    int input = getInput();
    if (input == 'p') {
      return InputOption.PLAY;
    } else if (input == 'h') {
      return InputOption.HIT;
    } else if (input == 's') {
      return InputOption.STAND;
    } else if (input == 'q') {
      return InputOption.QUIT;
    } else {
      return null;
    }
  }

  public void displayCard(model.Card card) {
    System.out.println("" + card.getValue() + " of " + card.getColor());
  }

  /**
   * Displays a pause.
   */
  public void displayPause() {
    System.out.println("*pause*");
    try {
      Thread.sleep(1500);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    }
  }

  /**
   * Displays the dealers cards and if the dealer got a card or not.
   *
   * @param hand the dealer's hand.
   * @param gotCard true if the dealer got a card, else false.
   */
  public void displayDealerPause(Iterable<model.Card> hand, boolean gotCard) {
    String str = " Dealer: ";
    str += displayCardString(hand);
    if (gotCard) {
      str += " (dealer got a card)";
    }
    System.out.println(str);
  }

  /**
   * Displays the cards and the status if player got a card or not.
   *
   * @param hand the player's hand.
   * @param gotCard true if the player got a card, else false.
   */
  public void displayPlayerPause(Iterable<model.Card> hand, boolean gotCard) {
    String str = " Player: ";
    str += displayCardString(hand);
    if (gotCard) {
      str += " (player got a card)";
    }
    System.out.println(str);
  }

  /**
   * Displays the cards of the player on one line.
   *
   * @param hand the player's hand.
   * @return the string to display.
   */
  private String displayCardString(Iterable<model.Card> hand) {
    String string = "";
    int index = 0;
    for (model.Card c : hand) {
      if (index == 0) {
        string += "" + c.getValue() + " of " + c.getColor();
      } else {
        string += ", " + c.getValue() + " of " + c.getColor();
      }
      index++;
    }
    return string;
  }

  public void displayPlayerHand(Iterable<model.Card> hand, int score) {
    displayHand("Player", hand, score);
  }

  public void displayDealerHand(Iterable<model.Card> hand, int score) {
    displayHand("Dealer", hand, score);
  }

  private void displayHand(String name, Iterable<model.Card> hand, int score) {
    System.out.println(name + " Has: ");
    for (model.Card c : hand) {
      displayCard(c);
    }
    System.out.println("Score: " + score);
    System.out.println("");
  }

  /**
   * Displays the winner of the game.

   * @param dealerIsWinner True if the dealer is the winner.
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("GameOver: ");
    if (dealerIsWinner) {
      System.out.println("Dealer Won!");
    } else {
      System.out.println("You Won!");
    }

  }
}
