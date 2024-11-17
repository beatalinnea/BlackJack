package model.rules;

import model.Dealer;
import model.Player;

class AmericanNewGameStrategy implements NewGameStrategy {

  public boolean newGame(Dealer dealer, Player player) {
    dealer.dealNextCard(player, true);
    dealer.dealNextCard(dealer, true);
    dealer.dealNextCard(player, true);
    dealer.dealNextCard(dealer, false);

    return true;
  }
}