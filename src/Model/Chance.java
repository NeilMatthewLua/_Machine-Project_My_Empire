package Model;
/**
 * Chance Class which is a subclass of land and is used as the chance space on game board
 *
 * Last Change Made: Created Class
 *
 * Previous Change:
 */
public abstract class Chance extends Land {
    public Chance(String strName){
        super(strName);
    }

    /**
     * Overridden method which gives player a card when stepped on
     * @param gameBoard instance of the game board
     * @param player the player which triggered the event
     * @return string which contains the details of the event
     */

    public abstract String triggerEvent(GameBoard gameBoard, Player player);
}

