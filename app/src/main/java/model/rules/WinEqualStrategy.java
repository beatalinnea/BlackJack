package model.rules;

import model.Dealer;
import model.Player;

/**
 * Rule interface that encapsulates if a dealer is the winner depending on the scores compared to the player.
 */
public interface WinEqualStrategy {
  /**
   * Checks if the dealer is the winner.

   * @param player the player to compare to.
   * @param dealer the dealer to compare to.
   * @return True if the rule decided the dealer is the winner, false otherwise.
   */
  boolean isDealerWinner(Player player, Dealer dealer);
}
