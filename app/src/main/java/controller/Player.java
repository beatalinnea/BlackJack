package controller;

import model.Game;
import view.View;
import view.View.InputOption;


/**
 * Scenario controller for playing the game.
 */
public class Player implements model.PauseObserver {

  private Game game;
  private View view;

  /**
   * Creates a new instance of the class.
   *
   * @param game The game to play.
   * @param view The view to present the game.
   */
  public Player(Game game, View view) {
    game.setObserver(this);
    this.game = game;
    this.view = view;
  }

  /**
   * Runs the play use case.
   *
   * @return True as long as the game should continue.
   */
  public boolean play() {

    view.displayWelcomeMessage();

    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    InputOption option = view.getOption();
    if (option == InputOption.PLAY) {
      game.newGame();
    } else if (option == InputOption.HIT) {
      game.hit();
    } else if (option == InputOption.STAND) {
      game.stand();
    }

    return option != InputOption.QUIT;
  }

  /**
   * Implements the observer pattern method update for the Pause Observer.
   *
   * @param player the player that called on the update.
   */
  public void update(model.Player player) {
    view.displayPause();
    if (player instanceof model.Dealer) {
      view.displayDealerPause(game.getDealerHand(), true);
      view.displayPlayerPause(game.getPlayerHand(), false);
    } else {
      view.displayDealerPause(game.getDealerHand(), false);
      view.displayPlayerPause(game.getPlayerHand(), true);
    }
  }
}