/**
 * Start class
 *
 * Last Change Made: Class Created
 *
 * Previous Change Made:
 */
public class Start extends Land{

    public Start(String strName){
        super(strName);
    }

    public String triggerEvent(GameBoard gameBoard, Player player){
        String event = "";
        double dAmount = gameBoard.getBank().getMoney();
        if(gameBoard.getBank().giveMoney(player,200) == true){
            event += player.getName() + " passed by START and got $200.";
        }
        else{
            event += player.getName() + " was given " + dAmount +
                    ".Bank is bankrupt.";
            gameBoard.setIsWin(true);
        }
        return event;
    }
}
