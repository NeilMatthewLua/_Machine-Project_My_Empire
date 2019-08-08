package Model;
/**
 * Tax Class which is a subclass of land and is used as the tax space on game board
 */
public class Tax extends Land {
    public Tax(String strName){
        super(strName);
    }

    /**
     * Overridden method which prompts Player to pay tax when stepped on
     * @param gameBoard instance of GameBoard which contains the game elements
     * @param player the Player which triggered the event
     * @return String which contains the details of the event
     */
    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        //Stores the amount to be paid
        double dRent = 0;
        //String which contains the name of the Tax space
        String space = "";
        //String which contains event details
        String event = "";
        //If space is a Luxury Tax Space
        if(this.getName().equalsIgnoreCase("Luxury Tax")){
            dRent = 75;
            space = " Luxury Tax Space";
        }
        //If space is an Income Tax Space
        else if(this.getName().equalsIgnoreCase("Income Tax")){
            dRent = ((player.getMoney() * .10) >= 200) ? player.getMoney() * .10 : 200;
            dRent = Math.round(dRent * 10) / 10.0;
            space = " Income Tax Space";
        }
        //Temporarily stores player money
        double dAmount = player.getMoney();
        //If the player can pay the bank
        if(player.giveMoney(gameBoard.getBank(),dRent)){
            event += player.getName() + " paid " + dRent + " for" + space + "." + "\n";
        }
        //If the player cannot pay the bank
        else{
            event += player.getName() + " paid " + dAmount + ". " + player.getName() + " is now bankrupt." + "\n";
            //Game ends
            gameBoard.setIsWin(true);
        }
        //Returns summary of event
        return event;
    }
}
