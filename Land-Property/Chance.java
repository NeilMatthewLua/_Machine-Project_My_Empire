package Model;
/**
 * Chance Class which is a subclass of land and is used as the chance space on game board
 *
 * Last Change Made: Created Class
 *
 * Previous Change:
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
    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        Card temp = gameBoard.drawChance();
        player.addCard(temp);
        String event = "Player drew " + temp.getDescription();
        String event2 = "";
        if(!temp.getCanKeep()){//If the card can't be kept then use the card
            gameBoard.getEvents().add(event);
            event2 += player.getCards().get(player.getCards().size()-1).useCard(player, gameBoard);
            return event2;
        }
        else
            return event;
    }
}

