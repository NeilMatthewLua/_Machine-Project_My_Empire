package Model;
/**
 * Parking Class which is a subclass of land and is used as the parking space on game board
 *
 * Last Change Made: Created Class
 *
 * Previous Change:
 */
public class Parking extends Land {
    public Parking(String strName){
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
        String event = player.getName() + " landed on free parking \n";
        event += player.getName() + " enjoy your free parking!";
        return event;
    }
}
