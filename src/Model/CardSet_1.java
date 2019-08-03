package Model;
/**
 * Card subclass which contains the cards from group 1. This includes the get out of jail card.
 *
 *  New Changes Made: Fixed Bugs
 
 *  Last Changes Made: Created this subclass

 */

public class CardSet_1 extends Card{

    public CardSet_1(int nIndex,int nGroup, boolean canKeep, String[][] list){
        super(nIndex, nGroup, canKeep, list);
    }


    /**
     * Abstracted method that triggers the effects of each card
     * @param player    player who got the card
     * @param gameBoard the gameboard
     * @return string which contains the details of the event
     */
    @Override
    public String useCard(Player player, GameBoard gameBoard){
        String event = "";
        player.setJail(false); //sets the player free from jail
        event += player.getName() + "used a get of jail card!"; //event to return in game log
        gameBoard.addCardDiscard(player.getCards().get(player.getCards().size() - 1)); //put used card into card discarded pile
        player.getCards().remove(player.getCards().size() - 1); //remove from the player's hand
        return event;
    }

}