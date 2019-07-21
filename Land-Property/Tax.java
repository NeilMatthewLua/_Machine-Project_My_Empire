/**
 * Tax class
 *
 * Last Change Made: Class Created
 *
 * Previous Change Made:
 */
public class Tax extends Land {
    public Tax(String strName){
        super(strName);
    }

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
        if(player.giveMoney(gameBoard.getBank(),dRent) == true){
            event += player.getName() + "paid " + dRent + " for" + space + ".";
        }
        else{
            event += player.getName() + "paid " + dAmount + ". " + player.getName() + " is now bankrupt.";
            gameBoard.setIsWin(true);
        }
        return event;
    }
}
