
/**
 * Card subclass which contains cards from group 4. This includes
 * the go to jail card or take a trip to property card.
 *
 *  New Changes Made: Fixed Bugs

 *  Last Changes Made: Created this subclass
 *   @author  Lua and Tanting
 *   @version 1.7
 */

package Model;

import java.util.Random;

public class CardSet_4 extends Card{

    public CardSet_4(int nIndex,int nGroup, boolean canKeep, String[][] list){
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
        int nIndex = player.getCards().get(player.getCards().size() - 1).getIndex(); //gets the index of the card to navigate through its set

        if(nIndex == 0){//Trip to jail, no money on start
            while(player.getPosition() != 16){
                player.setPosition(1);//Player moves one space
                if (gameBoard.getLand().get(player.getPosition()) instanceof Property)
                    if (((Property)gameBoard.getLand().get(player.getPosition())).getOwner() != null){
                        //If land is owned and is property type
                        ((Property)gameBoard.getLand().get(player.getPosition())).addFootTraffic();
                    }
            }
        }
        else if(nIndex == 1){//Trip to random property
            Random rand = new Random();
            int nRandProperty = rand.nextInt(32);
            while(!(gameBoard.getLand().get(nRandProperty) instanceof Property)){//Loops until a property is found
                nRandProperty = rand.nextInt(32);
            }
            while(player.getPosition() != nRandProperty){//While player has not landed on property
                player.setPosition(1);//Player moves one space
                if(player.getPosition() == 0){
                    event += ((Start)gameBoard.getLand().get(player.getPosition())).triggerEvent(gameBoard, player);

                }
                if (gameBoard.getLand().get(player.getPosition()) instanceof Property)
                    if (((Property)gameBoard.getLand().get(player.getPosition())).getOwner() != null){
                        //If land is owned and is property type
                        ((Property)gameBoard.getLand().get(player.getPosition())).addFootTraffic();
                    }
            }

        }

        gameBoard.addCardDiscard(player.getCards().get(player.getCards().size() - 1)); //put used card into card discarded pile
        player.getCards().remove(player.getCards().size() - 1); //remove from the player's hand
        return event;
    }
}