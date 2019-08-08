package Model;
/**
 * Start Class which is a subclass of land and is used as the start space on game board
 */
public class Start extends Land{

    public Start(String strName){
        super(strName);
    }

    /**
     * Overridden method where bank pays Player when stepped on or passed by
     * @param gameBoard instance of GameBoard which contains the game elements
     * @param player the Player which triggered the event
     * @return String which contains the details of the event
     */
    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        //String which contains event details
        String event = "";
        //Temporarily stores player money
        double dAmount = gameBoard.getBank().getMoney();
        //If the Bank can pay the player $200
        if(gameBoard.getBank().giveMoney(player,200)){
            event += player.getName() + " passed by START and got $200.\n";
        }
        //If the Bank cannot pay the player $200
        else{
            event += player.getName() + " was given " + dAmount +
                    ".\n Bank is bankrupt.\n";
            //Game ends
            gameBoard.setIsWin(true);
        }
        //Returns summary of event
        return event;
    }
}
