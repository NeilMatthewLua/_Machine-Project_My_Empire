package Model;
/**
 * Parking Class which is a subclass of land and is used as the parking space on game board
 *
 * Last Change Made: Created Class
 *
 * Previous Change:
 */
public class Parking extends Land {
    Parking(String strName){
        super(strName);
    }

    /**
     * Overridden method which triggers when player steps on free parking space
     * @param gameboard
     * @param player the player which triggered the event
     * @return string which contains the details of the event
     */
    @Override
    public String triggerEvent(GameBoard gameboard, Player player){
        return player.getName() + " enjoy your free parking!";
    }
}
