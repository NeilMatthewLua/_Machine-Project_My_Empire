/**
 * Chance Class
 *
 * Last Change Made: Created Class
 *
 * Previous Change:
 */
public class Chance extends Land {
    public Chance(String strName){
        super(strName);
    }

    public String triggerEvent(GameBoard gameBoard, Player player){
        Card temp = gameBoard.drawChance();
        player.addCard(temp);
        String event = "Player drew " + temp.getDescription();
        gameBoard.getEvents().add(event);
        String event2 = "";
        if(temp.getCanKeep() == false){
            //TODO Implement string returns in useCard
            //event2 += player.getCard().get(player.getCard().size()-1).useCard(player, gameBoard);
        }
        return event2;
    }
}

