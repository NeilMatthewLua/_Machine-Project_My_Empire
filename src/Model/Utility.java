package Model;
/**
 * Utility Class
 *
 * Last Change Made: Created Class
 *
 * Previous Change:
 */


public class Utility extends Ownable{
    private Player owner;

    public Utility(String strName, double dPrice){
        super(strName,dPrice);
        owner = null;
    }

    /**
     * Calculates the rent for the given utility
     * @param player the player which will pay the rent
     * @return
     */
    public double getRent(Player player){
        int nCounter = 0;
        double dRent = 0;
        for (int i = 0; i < owner.getProperties().size(); i++)
            if (owner.getProperties().get(i) instanceof Utility) {
                nCounter++;
            }
        switch (nCounter) {//Calculations made based on owned properties and dice rolls
            case 1:
                dRent = player.getLastRoll() * 4;
                break;
            case 2:
                dRent = player.getLastRoll() * 10;
                break;
            default:
                break;
        }
        return dRent;
    }

    /**
     * Overridden method which will prompt user to pay rent when stepped on
     * @param gameBoard instance of the game board
     * @param player the player which triggered the event
     * @return string which contains the details of the event
     */
    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        String event = "";
        double playerMoney = player.getMoney();
        if(player.giveMoney(owner, this.getRent(player))){
            event += player.getName() + " gave " + owner.getName() + " " + this.getRent(player) + ".";
        }
        else{
            event += player.getName() + " gave " + owner.getName() + " " + playerMoney;
            event += ". " + player.getName() + " is now bankrupt.";
            gameBoard.setIsWin(true);
        }
        return event;
    }
}
