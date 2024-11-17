package model;

/**
 * An interface for the observer pattern.
 */
public interface PauseObserver {
  /**
   * Updates the observer.
   *
   * @param player the player to update.
   */
  public void update(Player player);
}
