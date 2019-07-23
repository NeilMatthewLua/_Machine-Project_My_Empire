/**
 * Community class
 *
 * Last Change Made: Class Created
 *
 * Previous Change Made:
 */

package Model;

public class Community extends Land {
    public Community(String strName){
        super(strName);
    }

    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        String event = "";
        double dAmount = player.getMoney();
        if(player.giveMoney(gameBoard.getBank(),50)){
            event += player.getName() + "donated " + 50 + " to Bank.";
        }
        else{
            event += player.getName() + "donated " + dAmount + "to Bank. " + player.getName() + " is now bankrupt.";
            gameBoard.setIsWin(true);
        }
        return event;
    }
}
