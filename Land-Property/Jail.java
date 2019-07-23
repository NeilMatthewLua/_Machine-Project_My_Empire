/**
 * Jail class
 *
 * Last Change Made: updated getCard -> getCards
 *
 * Previous Change Made: Class Created
 */

package Model;

public class Jail extends Land {

    public Jail(String strName){
        super(strName);
    }

    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        String event = "";
        player.setJail(true);
        event += player.getName() + " was sent to Jail. " +
                player.getName() + " will pay $50 next turn.";
        if(player.getCards().get(0) instanceof CardSet_1){
            gameBoard.getEvents().add(event);
            return player.getCards().get(0).useCard(player,gameBoard);
        }
        else{
            return event;
        }
    }
}
