package Model;
/**
 * Tax Class which is a subclass of land and is used as the tax space on game board
 *
 * Last Change Made: Class Created
 *
 * Previous Change Made:
 *   @author  Lua and Tanting
 *   @version 1.7
 */
public class Tax extends Land {
    public Tax(String strName){
        super(strName);
    }

    /**
     * Overridden method which prompts player to pay tax when stepped on
     * @param gameBoard instance of the game board
     * @param player the player which triggered the event
     * @return string which contains the details of the event
     */
    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        double dRent = 0;
        String space = "";
        String event = "";
        if(this.getName().equalsIgnoreCase("Income Tax")){
            dRent = 75;
            space = " Luxury Tax Space";
        }
        else if(this.getName().equalsIgnoreCase("Luxury Tax")){
            dRent = ((player.getMoney() * .10) >= 200) ? player.getMoney() * .10 : 200;
            space = " Income Tax Space";
        }
        double dAmount = player.getMoney();
        event += player.getName() + " landed on " + space + "\n";
        if(player.giveMoney(gameBoard.getBank(),dRent)){
            event += player.getName() + "paid " + dRent + " for" + space + ".";
        }
        else{
            event += player.getName() + "paid " + dAmount + ". " + player.getName() + " is now bankrupt.";
            gameBoard.setIsWin(true);
        }
        return event;
    }
}
