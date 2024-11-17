package view;

/**
 * Encapsulates the generic view functionality.
 */
public interface View {

  /**
   * The different options that the user can make.
   */
  public enum InputOption {
    PLAY,
    HIT,
    STAND,
    QUIT;
  }

  /**
   * Shows a welcome message.
   */
  void displayWelcomeMessage();

  /**
   * Returns pressed characters from the keyboard.

   * @return the pressed character.
   */
  int getInput();

  /**
   * Returns the option that the user made.
   *
   * @return the option.
   */
  InputOption getOption();

  /**
   * Displays a card.

   * @param card The card to display.
   */
  void displayCard(model.Card card);

  /**
   * Displays a pause message.
   */
  void displayPause();

  /**
   * Displays the dealer's hand and if the dealer got a card or not.
   *
   * @param hand - the dealer's hand.
   * @param gotCard - true if the dealer got a card, else false.
   */
  void displayDealerPause(Iterable<model.Card> hand, boolean gotCard);

  /**
   * Displays the player's hand and if the player got a card or not.
   *
   * @param hand - the player's hand.
   * @param gotCard - true if the player got a card, else false.
   */
  void displayPlayerPause(Iterable<model.Card> hand, boolean gotCard);

  /**
   * Displays the cards and score of the player.

   * @param hand the player's hand.
   * @param score the player's score.
   */
  void displayPlayerHand(Iterable<model.Card> hand, int score);

  /**
   * Displays the cards and score of the dealer.

   * @param hand the dealer's score.
   * @param score the players's score.
   */
  void displayDealerHand(Iterable<model.Card> hand, int score);

  /**
   * Displays the winner of the game.

   * @param dealerIsWinner True if the dealer is the winner.
   */
  void displayGameOver(boolean dealerIsWinner);
}