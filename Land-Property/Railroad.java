/**
 * Railroad Class
 *
 * Last Change Made: Created Class
 *
 * Previous Change:
 */

package Model;

public class Railroad extends Land {
    double dPrice;
    Player owner;

    public Railroad(String strName, double dPrice){
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

    public double getRent(){
        int nCounter = 0;
        double dRent = 0;
        for(int i = 0; i < owner.getProperties().size(); i++)
            if(owner.getProperties().get(i) instanceof Railroad)
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

    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        String event = "";
        double playerMoney = player.getMoney();
        if(player.giveMoney(owner, this.getRent())){
            event += player.getName() + " gave " + owner.getName() + " " + this.getRent() + ".";
        }
        else{
            event += player.getName() + " gave " + owner.getName() + " " + playerMoney;
            event += ". " + player.getName() + " is now bankrupt.";
            gameBoard.setIsWin(true);
        }
        return event;
    }


}
