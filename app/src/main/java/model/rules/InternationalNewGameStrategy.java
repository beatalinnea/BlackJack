package model.rules;

import model.Dealer;
import model.Player;


class InternationalNewGameStrategy implements NewGameStrategy {

  public boolean newGame(Dealer dealer, Player player) {
    dealer.dealNextCard(player, true);
    dealer.dealNextCard(dealer, true);
    dealer.dealNextCard(player, true);

    return true;
  }
}