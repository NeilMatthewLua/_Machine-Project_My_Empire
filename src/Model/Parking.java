package Model;
/**
 * Parking Class which is a subclass of land and is used as the parking space on game board
 */
public class Parking extends Land {
    public Parking(String strName){
        super(strName);
    }

    /**
     * Overridden method which triggers when player steps on free parking space
     * @param gameboard instance of GameBoard which contains the game elements
     * @param player the player which triggered the event
     * @return string which contains the details of the event
     */
    @Override
    public String triggerEvent(GameBoard gameboard, Player player){
        //String which contains event details
        String event = player.getName() + " enjoy your free parking!\n";
        //Returns summary of event
        return event;
    }
}
