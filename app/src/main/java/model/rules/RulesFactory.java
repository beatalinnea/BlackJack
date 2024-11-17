package model.rules;

/**
 * Creates concrete rules.
 */
public class RulesFactory {

  /**
   * Creates the rule to use for the dealer's hit behavior.

   * @return The rule to use
   */
  public HitStrategy getHitRule() {
    // return new BasicHitStrategy();
    return new SoftHitStrategy();
  }

  /**
   * Crates the rule to use when starting a new game.

   * @return The rule to use.
   */
  public NewGameStrategy getNewGameRule() {
    // return new InternationalNewGameStrategy();
    return new AmericanNewGameStrategy();
  }

  /**
   * Creates the rule to use when deciding if the dealer is the winner.
   *
   * @return The rule to use.
   */
  public WinEqualStrategy getWinEqualStrategy() {
    return new DealerWinEqualStrategy();
    // return new PlayerWinEqualStrategy();
  }
}