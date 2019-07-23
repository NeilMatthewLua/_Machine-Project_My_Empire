
/**
 * Card class which acts as a template for the cards that can be used during the game
 *
 *  New Changes Made: Fixed Bugs
 
 *  Last Changes Made: Created this subclass

 */

package Model;

import java.util.Random;

public class CardSet_6 extends Card{

    public CardSet_6(int nIndex,int nGroup, boolean canKeep, String[][] list){
        super(nIndex, nGroup, canKeep, list);
    }

    @Override
    public String useCard(Player player, GameBoard gameBoard){
        String event = "";
        int nIndex = player.getCards().get(player.getCards().size() - 1).getIndex(); //gets the index of the card to navigate through its set

        int[] arrChoices = {50,100,150};
        Random rand = new Random();
        int value = rand.nextInt(3);
        double temp = player.getMoney();

        event += getDescription() + " " + arrChoices[value];

        if( player.giveMoney(gameBoard.getBank(),arrChoices[value])){//If player can't pay then he gives all he has and loses
            event += player.getName() + " pays $" + arrChoices[value] + " to: Bank" + "\n";
        }
        else{
            event += player.getName() + " pays $" + temp + " to: Bank" + "\n";
            event += player.getName() + " is now bankrupt. Game is over.";
            gameBoard.setIsWin(true);
        }


        gameBoard.addCardDiscard(player.getCards().get(player.getCards().size() - 1)); //put used card into card discarded pile
        player.getCards().remove(player.getCards().size() - 1); //remove from the player's hand
        return event;
    }
}