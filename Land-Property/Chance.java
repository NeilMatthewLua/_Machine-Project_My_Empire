/**
 * Chance Class
 *
 * Last Change Made: Created Class
 *
 * Previous Change:
 */

package Model;

public class Chance extends Land {
    public Chance(String strName){
        super(strName);
    }

    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        Card temp = gameBoard.drawChance();
        player.addCard(temp);
        String event = "Player drew " + temp.getDescription();
        String event2 = "";
        if(!temp.getCanKeep()){
            gameBoard.getEvents().add(event);
            event2 += player.getCards().get(player.getCards().size()-1).useCard(player, gameBoard);
            return event2;
        }
        else
            return event;
    }
}

