package model.rules;

import model.Dealer;
import model.Player;

/**
 * Rule interface that encapsulates if a dealer is the winner depending on the scores compared to the player.
 * This strategy is used when the player wins if the scores are equal.
 */
public class PlayerWinEqualStrategy  implements WinEqualStrategy {
  private static final int max = 21;

  /**
   * Checks if the dealer is the winner.
   *
   * @param player the player to compare to.
   * @param dealer the dealer to compare to.
   */
  public boolean isDealerWinner(Player player, Dealer dealer) {
    if (player.calcScore() > max) {
      return true;
    } else if (dealer.calcScore() > max) {
      return false;
    }
    return dealer.calcScore() > player.calcScore();
  }
}