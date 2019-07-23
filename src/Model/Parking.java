/*
 * Parking Class
 *
 * Last Change Made: Created Class
 *
 * Previous Change:
 */

package Model;

public class Parking extends Land {
    Parking(String strName){
        super(strName);
    }

    @Override
    public String triggerEvent(GameBoard gameboard, Player player){
        return player.getName() + " enjoy your free parking!";
    }
}
