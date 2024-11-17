package model.rules;

import model.Dealer;
import model.Player;

/**
 * A class for the dealer winning strategy. This strategy is used when the dealer wins if the scores are equal.
 */
public class DealerWinEqualStrategy implements WinEqualStrategy {
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
    return dealer.calcScore() >= player.calcScore();
  }
}
