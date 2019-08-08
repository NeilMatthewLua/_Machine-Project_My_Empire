package Model;
/**
 * Chance Class which is a subclass of land and is used as the chance space on game board
 */
public class Chance extends Land {
    public Chance(String strName){
        super(strName);
    }

    /**
     * Overridden method which gives Player a card when stepped on
     * @param gameBoard instance of GameBoard which contains the game elements
     * @param player the Player which triggered the event
     * @return String which contains the details of the event
     */
    public String triggerEvent(GameBoard gameBoard, Player player){
        //Temporarily stores the drawn card from the gameBoard
        Card temp = gameBoard.drawChance();
        //Adds the card to the player's arrayList of cards
        player.addCard(temp);
        String event = player.getName() + " drew  a card.\n";
        //Returns the summary of the event
        return event;
    }
}

