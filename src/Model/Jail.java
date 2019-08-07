package Model;
/**
 * Jail Class which is a subclass of land and is used as the Jail space on game board
 *
 * Last Change Made:
 *
 * Previous Change Made: Class Created
 *   @author  Lua and Tanting
 *   @version 1.7
 */
public class Jail extends Land {

    public Jail(String strName){
        super(strName);
    }

    /**
     * Overridden method which puts player in jail when stepped on
     * @param gameBoard instance of the game board
     * @param player the player which triggered the event
     * @return string which contains the details of the event
     */
    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        String event = "";
        player.setJail(true); //Player is put in jail
        event += player.getName() + " was sent to Jail. \n" +
                player.getName() + " will pay $50 next turn.\n";
        return event;
    }
}
