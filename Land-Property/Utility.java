/**
 * Utility Class
 *
 * Last Change Made: Created Class
 *
 * Previous Change:
 */


public class Utility extends Land{
    double dPrice;
    Player owner;

    public Utility(String strName, double dPrice){
        super(strName);
        this.dPrice = dPrice;
        owner = null;
    }

    public double getPrice(){
        return dPrice;
    }

    public Player getOwner(){
        return owner;
    }

    public void setOwner(Player player){
        this.owner = player;
    }

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

    public String triggerEvent(GameBoard gameBoard, Player player){
        String event = "";
        double playerMoney = player.getMoney();
        if(player.giveMoney(owner, this.getRent(player)) == true){
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
