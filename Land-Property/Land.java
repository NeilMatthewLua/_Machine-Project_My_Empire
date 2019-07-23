
/**
 * Land class which acts as a template for the different places found on the board
 *
 *  New Changes Made: Fixed Methods 
 *
 *  Last Changes Made: Made Land abstract
 *
 *   @author  Lua & Tanting
 *   @version 1.3
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
