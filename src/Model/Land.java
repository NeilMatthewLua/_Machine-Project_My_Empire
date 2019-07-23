
/**
 * Land class which acts as a template for the different places found on the board
 *
 *  New Changes Made: Made Land abstract
 *
 *  Last Changes Made: Fixed bug which gave bank all of player's money
 *
 *   @author  Lua & Tanting
 *   @version 1.2
 */

package Model;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Land {
    private String strName;

    public Land(String strName){
        this.strName = strName;
    }

    public String getName() {
        return strName;
    }

    public abstract String triggerEvent(GameBoard gameBoard, Player player);
}
