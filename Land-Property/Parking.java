/**
 * Parking Class
 *
 * Last Change Made: Created Class
 *
 * Previous Change:
 */
public class Parking extends Land {
    Parking(String strName){
        super(strName);
    }

    public String triggerEvent(GameBoard gameboard, Player player){
        return player.getName() + " enjoy your free parking!";
    }
}
