package Model;
/**
 * Utility Class which is a subclass of Ownable and contains utility spaces
 * It also implements the IsRentable interface.
 */


public class Utility extends Ownable implements IsRentable{

    public Utility(String strName, double dPrice){
        super(strName,dPrice);
    }

    /**
     * Calculates the rent for the given Utility
     * @param player the player which will pay the rent
     * @return the rent of the Utility
     */
    @Override
    public double getRent(Player player){
        //Counts the number of Utilities owner has
        int nCounter = 0;
        //Stores the value of the rent of the Utility
        double dRent = 0;
        //Counts the number of Utilities owner has
        for (int i = 0; i < getOwner().getProperties().size(); i++)
            if (getOwner().getProperties().get(i) instanceof Utility) {
                nCounter++;
            }
        //Calculations made based on owned Utilities and dice rolls of the player that landed
        switch (nCounter) {
                //If owner has one Utility then rent is dice roll times 4
            case 1:
                dRent = player.getLastRoll() * 4;
                break;
                //If owner has two Utilities then rent is dice roll times 10
            case 2:
                dRent = player.getLastRoll() * 10;
                break;
            default:
                break;
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
        if(player.giveMoney(getOwner(), (Math.round(this.getRent(player)*10) / 10))){
            event += player.getName() + " gave " + getOwner().getName() + " " + (Math.round(this.getRent(player)*10) / 10) + "." + "\n";
        }
        //If the player cannot pay
        else{
            event += player.getName() + " gave " + getOwner().getName() + " " + playerMoney;
            event += ". \n" + player.getName() + " is now bankrupt.\n";
            //Game ends
            gameBoard.setIsWin(true);
        }
        //Returns summary of event
        return event;
    }
}
