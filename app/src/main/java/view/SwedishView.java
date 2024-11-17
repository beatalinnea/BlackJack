package view;

/**
 * Implements a Swedish console view.
 */
public class SwedishView implements View {

  /**
   * Shows a welcome message.
   */
  public void displayWelcomeMessage() {
    for (int i = 0; i < 2; i++) {
      System.out.print("\n");
    }

    System.out.println("Black Jack Världen");
    System.out.println("------------------");
    System.out.println("Skriv 's' för att Spela, 'd' för att dra nytt kort, 'p' för att passa, 'a' för att avsluta\n");
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
    if (input == 's') {
      return InputOption.PLAY;
    } else if (input == 'd') {
      return InputOption.HIT;
    } else if (input == 'p') {
      return InputOption.STAND;
    } else if (input == 'a') {
      return InputOption.QUIT;
    } else {
      return null;
    }
  }

  /**
   * Displays a card.

   * @param card The card to display.
   */
  public void displayCard(model.Card card) {
    if (card.getColor() == model.Card.Color.Hidden) {
      System.out.println("- Dolt Kort");
    } else {
      String[] colors = { "Hjärter", "Spader", "Ruter", "Klöver" };
      String[] values = { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio",
                          "knekt", "dam", "kung", "ess" };
      System.out.println("- " + colors[card.getColor().ordinal()] + " " + values[card.getValue().ordinal()]);
    }
  }

  /**
   * Displays and creates a pause in the game.
   */
  public void displayPause() {
    System.out.println("*paus*"); // move to view
    try {
      Thread.sleep(1500);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    }
  }

  /**
   * Displays the cards of the dealer and the status if given a card.
   *
   * @param hand the dealer's hand.
   * @param gotCard true if the dealer got a card, else false.
   */
  public void displayDealerPause(Iterable<model.Card> hand, boolean gotCard) {
    if (gotCard) {
      System.out.println("Croupier: (fick ett kort)");
    } else {
      System.out.println("Croupier: ");
    }
    for (model.Card c : hand) {
      displayCard(c);
    }
  }

  /**
   * Displays the cards of the player and the status if given a card.
   *
   * @param hand the player's hand.
   * @param gotCard true if the player got a card, else false.
   */
  public void displayPlayerPause(Iterable<model.Card> hand, boolean gotCard) {
    if (gotCard) {
      System.out.println("Spelare: (fick ett kort)");
    } else {
      System.out.println("Spelare: ");
    }
    for (model.Card c : hand) {
      displayCard(c);
    }
  }

  public void displayPlayerHand(Iterable<model.Card> hand, int score) {
    displayHand("Spelare", hand, score);
  }

  public void displayDealerHand(Iterable<model.Card> hand, int score) {
    displayHand("Croupier", hand, score);
  }

  /**
   * Displays the winner of the game.

   * @param dealerIsWinner True if the dealer is the winner.
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("Slut: ");
    if (dealerIsWinner) {
      System.out.println("Croupiern Vann!");
    } else {
      System.out.println("Du vann!");
    }
  }

  private void displayHand(String name, Iterable<model.Card> hand, int score) {
    System.out.println(name + " Har: " + score);
    for (model.Card c : hand) {
      displayCard(c);
    }
    System.out.println("Poäng: " + score);
    System.out.println("");
  }
}
