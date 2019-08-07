package Model;
/**
 * Community Class which is a subclass of land and is used as the community space on game board
 *
 * Last Change Made: Class Created
 *
 * Previous Change Made:
 *   @author  Lua and Tanting
 *   @version 1.7
 */
public class Community extends Land {
    public Community(String strName){
        super(strName);
    }

    /**
     * Overridden method which taxes player $50 for community space when stepped on
     * @param gameBoard instance of the game board
     * @param player the player which triggered the event
     * @return string which contains the details of the event
     */
    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        String event = "";
        double dAmount = player.getMoney();
        if(player.giveMoney(gameBoard.getBank(),50)){//If the player can pay the bank
            event += player.getName() + " donated " + 50 + " to Bank.";
        }
        else{//If the player can't pay the bank
            event += player.getName() + " donated " + dAmount + "to Bank. \n" + player.getName() + " is now bankrupt.";
            gameBoard.setIsWin(true);
        }
        return event;
    }
}
