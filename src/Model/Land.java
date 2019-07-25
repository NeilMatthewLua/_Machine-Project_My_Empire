package Model;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Land class which acts as a template for the different places found on the board
 *
 *  New Changes Made: Added Javadoc
 *
 *  Last Changes Made: Made Land abstract
 *
 *   @author  Lua & Tanting
 *   @version 1.2
 */
public abstract class Land {
    private String strName;

    public Land(String strName){
        this.strName = strName;
    }

    /**
     * Returns the name of the land space
     * @return the name of the land space
     */
    public String getName() {
        return strName;
    }

    /**
     * Abstract method which is implemented differently in subclasses
     * @param gameBoard instance of the game board
     * @param player the player which triggered the event
     * @return string which contains the details of the event
     */
    public abstract String triggerEvent(GameBoard gameBoard, Player player);
}
