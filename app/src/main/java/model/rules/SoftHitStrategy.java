package model.rules;

import model.Card;
import model.Player;

/**
 * Strategy for the dealer to use Soft Seventeen rule.
 */
public class SoftHitStrategy implements HitStrategy {
  /**
   * The dealer should hit if the score is 17 and it's a Soft 17.
   *
   * @param dealer The dealer to check if a soft 17.
   */
  public boolean doHit(Player dealer) {
    int score = dealer.calcScore();
    if (score == 17 && isSoftSeventeen(dealer)) {
      return true;
    }
    // If none of the above conditions are met, the dealer should not hit.
    return score < 17;
  }

  private boolean isSoftSeventeen(Player dealer) {
    int numAces = 0;
    int totalValue = 0;

    for (Card card : dealer.getHand()) {
      if (card.getValue() == Card.Value.Ace) {
        numAces++;
      } else if (card.getValue() == Card.Value.Two) {
        totalValue += 2;
      } else if (card.getValue() == Card.Value.Three) {
        totalValue += 3;
      } else if (card.getValue() == Card.Value.Four) {
        totalValue += 4;
      } else if (card.getValue() == Card.Value.Five) {
        totalValue += 5;
      } else if (card.getValue() == Card.Value.Six) {
        totalValue += 6;
      } else {
        return false; // If any card is higher than 6, this isn't a Soft 17.
      }
    }

    // Adjust the total value to exclude all Aces except one - total for the rest of
    // all except one ace should be 6.
    if (numAces > 1) {
      totalValue += numAces - 1;
    }

    // Check if it's a Soft 17 (One Ace and cards totaling 6).
    if (numAces > 0 && totalValue == 6) {
      return true; // Soft 17: At least one Ace and other cards totaling 6, dealer should hit
    } else {
      return false; // If it's not a Soft 17, the dealer should not hit.
    }
  }
}
