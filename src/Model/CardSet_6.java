package Model;
import java.util.Random;

/**
 * Card subclass which contains cards from group 6. This includes payment cards with randomly generated amounts that can either be 50, 100, or 150.
 */

public class CardSet_6 extends Card{

    public CardSet_6(int nIndex,int nGroup, boolean canKeep, String[][] list){
        super(nIndex, nGroup, canKeep, list);
    }

    /**
     * Abstracted method that triggers the effects of each card
     * @param player    player who got the card
     * @param gameBoard GameBoard where the Players are playing on
     * @return string which contains the details of the event
     */
    @Override
    public String useCard(Player player, GameBoard gameBoard){
        String event = "";
        //gets the index of the card to navigate through its set
        int nIndex = player.getCards().get(player.getCards().size() - 1).getIndex(); 

        //Random amount decided either 50 100 or 150
        int[] arrChoices = {50,100,150};
        Random rand = new Random();
        //Gets a random index from array
        int value = rand.nextInt(3);
        double temp = player.getMoney();

        //If player can't pay then he gives all he has and loses
        if(player.giveMoney(gameBoard.getBank(),arrChoices[value])){
            event += player.getName() + " pays $" + arrChoices[value] + " to: Bank. " + "\n";
        }
        else{
            event += player.getName() + " pays $" + temp + " to: Bank." + "\n";
            event += player.getName() + " is now bankrupt. Game is over.";
            gameBoard.setIsWin(true);
        }

        //put used card into card discarded pile
        gameBoard.addCardDiscard(player.getCards().get(player.getCards().size() - 1)); 
        //remove from the player's hand
        player.getCards().remove(player.getCards().size() - 1); 
        
        return event;
    }
}