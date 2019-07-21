/**
 * Jail class
 *
 * Last Change Made: Class Created
 *
 * Previous Change Made:
 */
public class Jail extends Land {

    public Jail(String strName){
        super(strName);
    }

    public String triggerEvent(GameBoard gameBoard, Player player){
        String event = "";
        player.setJail(true);
        event += player.getName() + " was sent to Jail. " +
                player.getName() + " will pay $50 next turn.";
        return event;
    }
}
