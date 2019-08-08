package Model;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Land class which acts as a template for the different places found on the board
 */
public abstract class Land {
    //String name of the Land
    private String strName;

    public Land(String strName){
        this.strName = strName;
    }

    /**
     * Getter for Land name
     * @return Land name
     */
    public String getName() {
        return strName;
    }

    /**
     * Abstract method which is implemented differently in subclasses
     * @param gameBoard instance of the GameBoard which contains the game elements
     * @param player the Player which triggered the event
     * @return String which contains the details of the event
     */
    public abstract String triggerEvent(GameBoard gameBoard, Player player);
}
