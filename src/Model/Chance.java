package Model;
/**
 * Chance Class which is a subclass of land and is used as the chance space on game board
 *
 * Last Change Made: Created Class
 *
 * Previous Change:
 *   @author  Lua and Tanting
 *   @version 1.7
 */
public class Chance extends Land {
    public Chance(String strName){
        super(strName);
    }

    /**
     * Overridden method which gives player a card when stepped on
     * @param gameBoard instance of the game board
     * @param player the player which triggered the event
     * @return string which contains the details of the event
     */

    public String triggerEvent(GameBoard gameBoard, Player player){
        Card temp = gameBoard.drawChance();
        player.addCard(temp);
        String event = player.getName() + " drew  a card";

        return event;
    }
}

