package Model;
/**
 * Start Class which is a subclass of land and is used as the start space on game board
 *
 * Last Change Made: Class Created
 *
 * Previous Change Made:
 */
public class Start extends Land{

    public Start(String strName){
        super(strName);
    }

    /**
     * Overridden method which gives player $200 when passed or stepped on
     * @param gameBoard instance of the game board
     * @param player the player which triggered the event
     * @return string which contains the details of the event
     */
    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        String event = "";
        double dAmount = gameBoard.getBank().getMoney();
        if(gameBoard.getBank().giveMoney(player,200)){
            event += player.getName() + " passed by START and got $200.";
        }
        else{
            event += player.getName() + " was given " + dAmount +
                    ".Bank is bankrupt.";
            gameBoard.setIsWin(true);
        }
        return event;
    }
}
