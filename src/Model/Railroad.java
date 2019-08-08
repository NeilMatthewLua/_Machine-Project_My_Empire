package Model;
/**
 * Railroad Class which is a subclass of land and is used as the railroad space on game board
 * It also implements the IsRentable interface.
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
        //Counts the number of Railroads owner has
        int nCounter = 0;
        //Stores the value of the rent of the Railroad
        double dRent = 0;
        //Counts the number of Railroads owner has
        for(int i = 0; i < player.getProperties().size(); i++)
            if(player.getProperties().get(i) instanceof Railroad)
                nCounter++;
        //Calculations made based on no. of Railroads owner has
        switch(nCounter) {
            case 1: //If owner has one Railroad
                dRent = 25;
                break;
            case 2: //If owner has two Railroads
                dRent = 50;
                break;
            case 3: //If owner has three Railroads
                dRent = 150;
                break;
            default: break;
        }
        //The rent multiplier to be applied to rent
        double multiplier = 1;
        //Loops through the different Card multipliers
        for(int i = 0; i < getCardMultipliers().size();i++){
                multiplier *= ((CardSet_5)getCardMultipliers().get(i)).getMultiplier();
        }
        //Apply the multiplier to the rent
        dRent *= multiplier;
        return dRent;
    }

    /**
     * Overridden method which will prompt Player to pay rent when stepped on
     * @param gameBoard instance of GameBoard which contains the game elements
     * @param player the Player which triggered the event
     * @return String which contains the details of the event
     */
    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        //String which contains event details
        String event = "";
        //Temporarily stores player money
        double playerMoney = player.getMoney();
        //If player is able to pay
        if(player.giveMoney(getOwner(), (Math.round(this.getRent(this.getOwner())*10) / 10))){//If the player can pay
            event += player.getName() + " gave " + getOwner().getName() + " " + (Math.round(this.getRent(this.getOwner())*10) / 10) + ".\n";
        }
        //If the player cannot pay
        else{
            event += player.getName() + " gave " + getOwner().getName() + " " + playerMoney;
            event += ".\n" + player.getName() + " is now bankrupt.\n";
            gameBoard.setIsWin(true);
        }
        //Returns summary of event
        return event;
    }
}
