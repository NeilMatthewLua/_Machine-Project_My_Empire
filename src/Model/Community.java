package Model;
/**
 * Community Class which is a subclass of land and is used as the community space on game board
 */
public class Community extends Land {
    public Community(String strName){
        super(strName);
    }

    /**
     * Overridden method which taxes Player when landed on
     * @param gameBoard instance of GameBoard which contains the game elements
     * @param player the player which triggered the event
     * @return string which contains the details of the event
     */
    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        //String which contains event details
        String event = "";
        //Temporarily stores player money
        double dAmount = player.getMoney();
        //If the player can pay the bank
        if(player.giveMoney(gameBoard.getBank(),50)){//If the player can pay the bank
            event += player.getName() + " donated " + 50 + " to Bank.\n";
        }
        //If the player can't pay the bank
        else{
            event += player.getName() + " donated " + dAmount + "to Bank. \n" + player.getName() + " is now bankrupt.\n";
            gameBoard.setIsWin(true);
        }
        //Returns summary of event
        return event;
    }
}
