package Model;
/**
 * Railroad Class which is a subclass of land and is used as the railroad space on game board
 *
 * Last Change Made: Created Class
 *
 * Previous Change:
 */
public class Railroad extends Ownable {

    public Railroad(String strName, double dPrice){
        super(strName,dPrice);
    }

    /**
     * Calculates the rent for the given railroad
     * @return the rent of the railroad
     */
    public double getRent(){
        int nCounter = 0;
        double dRent = 0;
        for(int i = 0; i < getOwner().getProperties().size(); i++)
            if(getOwner().getProperties().get(i) instanceof Railroad)
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
        if(player.giveMoney(getOwner(), this.getRent())){//If the player can pay
            event += player.getName() + " gave " + getOwner().getName() + " " + this.getRent() + ".";
        }
        else{//If the player cannot pay
            event += player.getName() + " gave " + getOwner().getName() + " " + playerMoney;
            event += ". " + player.getName() + " is now bankrupt.";
            gameBoard.setIsWin(true);
        }
        return event;
    }


}
