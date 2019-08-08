package Model;
/**
 * Jail Class which is a subclass of land and is used as the Jail space on game board
 */
public class Jail extends Land {

    public Jail(String strName){
        super(strName);
    }

    /**
     * Overridden method which puts Player in jail when stepped on
     * @param gameBoard instance of GameBoard which contains the game elements
     * @param player the Player which triggered the event
     * @return String which contains the details of the event
     */
    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        //String which contains event details
        String event = "";
        //Player is put in jail
        player.setJail(true);
        //Summary of event is returned
        event += player.getName() + " was sent to Jail. \n" +
                player.getName() + " will pay $50 next turn.\n";
        //Returns summary of event
        return event;
    }
}
