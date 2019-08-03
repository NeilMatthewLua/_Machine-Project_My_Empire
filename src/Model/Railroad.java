package Model;
/**
 * Railroad Class which is a subclass of land and is used as the railroad space on game board
 *
 * Last Change Made: Created Class
 *
 * Previous Change:
 *   @author  Lua and Tanting
 *   @version 1.7
 */
public class Railroad extends Ownable implements IsRentable{

    public Railroad(String strName, double dPrice){
        super(strName,dPrice);
    }

    /**
     * Gets the rent of the railroad
     * @param player the owner of the railroad
     * @return the computed cost of the rent
     */
    @Override
    public double getRent(Player player){
        int nCounter = 0;
        double dRent = 0;
        for(int i = 0; i < player.getProperties().size(); i++)
            if(player.getProperties().get(i) instanceof Railroad)
                nCounter++;
        switch(nCounter) {//Calculations made based on no. of railroads owner has
            case 1:
                dRent = 25;
                break;
            case 2:
                dRent = 50;
                break;
            case 3:
                dRent = 150;
                break;
            default: break;
        }
        return dRent;
    }

    /**
     * Overridden method which asks player to pay rent when stepped on
     * @param gameBoard instance of the game board
     * @param player the player which triggered the event
     * @return string which contains the details of the event
     */
    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        String event = "";
        double playerMoney = player.getMoney();
        if(player.giveMoney(getOwner(), this.getRent(this.getOwner()))){//If the player can pay
            event += player.getName() + " gave " + getOwner().getName() + " " + this.getRent(this.getOwner()) + ".";
        }
        else{//If the player cannot pay
            event += player.getName() + " gave " + getOwner().getName() + " " + playerMoney;
            event += ". " + player.getName() + " is now bankrupt.";
            gameBoard.setIsWin(true);
        }
        return event;
    }
}
